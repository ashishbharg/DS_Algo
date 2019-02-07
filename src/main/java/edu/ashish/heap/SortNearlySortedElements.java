package edu.ashish.heap;

import edu.ashish.util.PrintingUtil;

/**
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts these elements.
 *
 * Time Complexity: O(nlogk)
 * Space Complexity: O(k) which is used as auxiliary array
 */
public class SortNearlySortedElements {

    public static void main(String[] args) {

        int[] arr = {6, 5, 3, 2, 8, 10, 9, 15, 17, 13, 11};
        int k = 3;

        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        sortNearlySortedElements(arr, k);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static int[] sortNearlySortedElements(int[] arr, int k) {

        int[] aux = new int[k + 1];
        int N = 0;

        // Step 1. Create min heap of k + 1 elements
        for (int i = 0; i <= k; i++) {
            N = insertInHeap(arr[i], aux, N);
        }

        // Step 2. Get the minimum element from auxiliary array and put it in original array and
        // insert next element in heap.
        for (int i = k + 1, j = 0; i < arr.length; i++, j++) {
            N = deleteMin(arr, aux, N, j);
            N = insertInHeap(arr[i], aux, N);
        }

        // Get the remaining element from auxiliary array and put it in the original array.
        for (int i = 0, j = arr.length - k - 1; i < aux.length; i++, j++) {
            N = deleteMin(arr, aux, N, j);
        }

        return aux;
    }

    private static int deleteMin(int[] arr, int[] aux, int index, int i) {
        int minElement = aux[0];
        aux[0] = aux[--index];
        sink(aux, 0, index);
        aux[index] = 0;
        arr[i] = minElement;
        return index;
    }

    private static void sink(int[] aux, int index, int N) {

        while (2 * index < N) {
            int childIndex = 2 * index + 1;
            if (childIndex >= N) {
                break;
            }
            if (aux[childIndex] > aux[childIndex + 1]) {
                childIndex++;
            }

            if (aux[index] > aux[childIndex]) {
                exch(aux, index, childIndex);
            } else {
                break;
            }
            index = childIndex;
        }

    }

    // This is min heap
    private static int insertInHeap(int element, int[] aux, int index) {

        aux[index] = element;
        swim(aux, index);
        index++;
        return index;
    }

    private static void swim(int[] aux, int index) {

        int parentIndex = (index - 1) / 2;
        while (index > 0 && aux[parentIndex] > aux[index]) {
            exch(aux, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private static void exch(int[] aux, int index, int parentIndex) {
        int temp = aux[index];
        aux[index] = aux[parentIndex];
        aux[parentIndex] = temp;
    }
}
