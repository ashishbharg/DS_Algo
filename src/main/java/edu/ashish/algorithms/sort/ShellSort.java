package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

/**
 * Shell SOrt. This is an improved version of insertion sort. h-sorting is done to sort the elements. Insertion
 * sort takes less time to sort if array is nearly sorted hence improving its running time. To find out h,
 * 2 * h + 1 should be used as formula.
 *
 * Worst case time Complexity: O(n ^ 3/2) which is better than other sorting algorithms
 *
 * Note: This should be used only when array is not huge.
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {/*30, */20, 50, 5, 60, 25, 55, 15};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        shellSort(arr);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void shellSort(int[] arr) {

        int N = arr.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {

             for (int i = h; i < N; i++) {
                 for (int j = i; j >=h && less(arr, j, j - h); j-=h) {
                     exch(arr, h, j);
                 }
             }
             h = h / 3;
        }
    }

    private static void exch(int[] arr, int h, int j) {
        int temp = arr[j];
        arr[j] = arr[j - h];
        arr[j - h] = temp;
    }

    private static boolean less(int[] arr, int i, int j) {
        if (arr[i] < arr[j]) {
                return true;
        }
        return false;
    }
}
