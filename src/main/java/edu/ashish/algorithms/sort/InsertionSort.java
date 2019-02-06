package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

/**
 * Insertion Sort. Approach is to pick element and scan backwards and insert it at the right position in
 * such a way that the elements are sorted.
 *
 * Time Complexity: O(n^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        insertionSort(arr);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
            }
        }
    }
}
