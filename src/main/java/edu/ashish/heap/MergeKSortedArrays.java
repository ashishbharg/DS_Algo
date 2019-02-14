package edu.ashish.heap;

import static edu.ashish.util.PrintingUtil.print1DArray;

/**
 * Given k sorted arrays of size n each, merge them and print the sorted output.
 *
 * Time Complexity: O(nk.logk)
 */
public class MergeKSortedArrays {

    public static void main(String[] args) {

        int [][] arr = {{5, 8, 10},
                        {3, 6, 9, 12},
                        {2, 4}};
        int k = 3;
        int[] result = mergeKSortedArrays(arr, 3);
        System.out.println("Post merging of k-sorted array: ");
        print1DArray(result);
    }

    private static int[] mergeKSortedArrays(int[][] arr, int k) {

        int totalSize = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSize += arr[i].length;
        }
        int[] result = new int[totalSize];
        MinHeap[] minHeap = new MinHeap[k];
        for (int i = 0; i < k; i++) {
            minHeap[i] = new MinHeap(arr[i][0], i, 1);
        }

        createMinHeap(minHeap, k);

        for (int i = 0; i < totalSize; i++) {
            MinHeap minElement = minHeap[0];
            result[i] = minElement.data;
            if (minElement.nextIndex < arr[minElement.arrayNumber].length) {
                minHeap[0] = new MinHeap(arr[minElement.arrayNumber][minElement.nextIndex],
                        minElement.arrayNumber, ++minElement.nextIndex);
            } else {
                minHeap[0] = minHeap[--k];
            }
            sink(minHeap, 1, k);

        }
        return result;
    }

    private static void createMinHeap(MinHeap[] minHeap, int N) {

        int index = N / 2;
        while (index > 0) {
            sink(minHeap, index, N);
            index--;
        }
    }

    private static void sink(MinHeap[] minHeap, int index, int arrayLength) {

        int childIndex = 2 * index;
        while (childIndex <= arrayLength) {

            if (childIndex < arrayLength && minHeap[childIndex - 1].compareTo(minHeap[childIndex]) > 0) {
                childIndex++;
            }

            if (minHeap[index - 1].compareTo(minHeap[childIndex - 1]) > 0) {
                exch(minHeap, index, childIndex);
            } else {
                break;
            }
            index = childIndex;
            childIndex = 2 * index;
        }
    }

    private static void exch(MinHeap[] minHeap, int index, int childIndex) {
        MinHeap temp = minHeap[index - 1];
        minHeap[index - 1] = minHeap[childIndex - 1];
        minHeap[childIndex - 1] = temp;
    }

    private static class MinHeap implements Comparable<MinHeap> {
        private int data;
        private int arrayNumber;
        private int nextIndex;

        public MinHeap(int data, int arrayNumber, int nextIndex) {
            this.data = data;
            this.arrayNumber = arrayNumber;
            this.nextIndex = nextIndex;
        }

        @Override
        public int compareTo(MinHeap o) {
            return this.data - o.data;
        }
    }
}
