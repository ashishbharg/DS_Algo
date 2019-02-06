package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

/**
 * Bubble sort. This sorting algorithm starts from 0th index every time and swap elements in each pass where comparison
 * is failed. With each pass, the last index of array will be in sorted order. Hence the comparison of elements go from
 * 0 to array length - 1 - round where round is the variable fo outer loop.
 *
 * Time Complexity: O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        bubbleSort(arr);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void bubbleSort(int[] arr) {

        boolean isSorted = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }

            // This check will make time complexity in best case to be O(n) where array is already sorted,
            // else in absence of this check, it will be O(n^2) even in case of already sorted array.
            if (isSorted) {
                break;
            }
        }
    }
}
