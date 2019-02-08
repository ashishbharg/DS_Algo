package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

import java.util.Arrays;

/**
 * Counting sort. This sorting algorithm is applied where the range of numbers or characters is not large. It
 * also acts as a base for Radix Sort.
 *
 * Time Complexity: O(n+k)
 * Space Complexity: O(k) where k is the maximum value array holds
 */
public class CountingSort {

    public static void main(String[] args) {

        int[] arr = {9, 4, 0, 3, 5, 8, 4, 0, 8, 0};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        int maxValue = 9;
        countingSort(arr, maxValue);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void countingSort(int[] arr, int maxValue) {

        // Assuming array is between 0 and 9.
        int[] aux = new int[maxValue + 1];
        for (int i = 0; i < arr.length; i++) {
            aux[arr[i]] = aux[arr[i]] + 1;
        }
        for (int i = 1; i < aux.length; i++) {
            aux[i] = aux[i - 1] + aux[i];
        }

        int[] res = new int[arr.length];
        // Loop is traversed in reverse order to make the sorting stable.
        for (int i = arr.length - 1; i >= 0; i--) {
            res[aux[arr[i]]-1] = arr[i];
            aux[arr[i]] = aux[arr[i]] - 1;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }
}
