package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

/**
 * Merge sort. This uses auxiliary space as compared to quick sort which doesn't take any extra space.
 *
 * Time Complexity: O(nlogn)
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void mergeSort(int[] arr, int lo, int hi) {

        int[] aux = new int[arr.length];
        mergeSort(arr, aux, lo, hi);
    }

    private static void mergeSort(int[] arr, int[] aux, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}
