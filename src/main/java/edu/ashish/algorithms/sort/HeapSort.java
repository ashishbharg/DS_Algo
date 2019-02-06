package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

/**
 * Heap Sort. Approach is to first rearrange elements to create max heap and call the max heap element and
 * swap it with last element of the heap and again correct the heap. Once heap is corrected, reduce the heap
 * size by 1 and reiterate the process.
 *
 * Time Complexity: O(nlogn) even in the worst case scenario.
 *
 * Drawbacks of heap sort w.r.t. quicksort are:
 * 1. Inner loop is longer than quick sort.
 * 2. Makes poor use of memory cache.
 * 3. Not stable.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        heapSort(arr);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void heapSort(int[] arr) {

        int n = arr.length;

        // Creates a max heap.
        for (int i = n/2; i > 0; i--) {
            sink(arr, i, n);
        }

        // Heapify and correct the heap accordingly.
        while (n > 1) {
            exchange(arr, 1, n--);
            sink(arr, 1, n);
        }
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = temp;
    }

    private static void sink(int[] arr, int index, int arrLength) {

        while (2 * index <= arrLength) {
            int j = 2 * index;
            if (j < arrLength && arr[j - 1] < arr[j]) {
                j++;
            }
            if (arr[index - 1] > arr[j - 1]) {
                break;
            }
            exchange(arr, j, index);
            index = j;
        }
    }
}
