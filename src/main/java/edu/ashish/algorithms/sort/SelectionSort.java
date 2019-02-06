package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

/**
 * Selection Sort. Approach is to scan the data structure till the end and find out the minimum element.
 * The array will start sorting from first as minimum element will always come on the starting index.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        selectionSort(arr);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
