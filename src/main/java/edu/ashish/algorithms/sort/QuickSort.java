package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

import java.util.Random;

/**
 * Quick Sort algorithm
 *
 * Best case time complexity - O(nlogn)
 * Worst case time compleixty - O(n^2)
 *
 * Worst case time complexity comes when array is already sorted or almost sorted. In order to achieve best case time
 * complexity, we should shuffle the array properly so that elements in array are in guaranteed random order.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        quickSort(arr);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void quickSort(int[] arr) {

        shuffle(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    private static void shuffle(int[] arr) {

        int n = arr.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            // This will fetch random number from 0 to bound exclusive. (n - i) will return the index position
            // of array length. Hence bound will be from 0 to array length - 1.
            int rand = random.nextInt(n - i);
            System.out.println(rand);
            // Between i and array length - 1
            int r = i + rand;
            swap(arr, i, r);
        }
        System.out.println("Array after shuffling");
        PrintingUtil.print1DArray(arr);
    }

    private static void quickSort(int[] arr, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {

        int i = lo;
        int j = hi + 1;

        while (true) {
            while (arr[++i] < arr[lo]) {
                if (i == hi) {
                    break;
                }
            }

            while (arr[--j] > arr[lo]) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
