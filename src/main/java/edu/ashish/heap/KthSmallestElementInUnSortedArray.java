package edu.ashish.heap;

import edu.ashish.util.PrintingUtil;

import java.util.Random;

/**
 * Program to find kth smallest number from unsorted array.
 *
 * Time Complexity: O(klogn)
 */
public class KthSmallestElementInUnSortedArray {

    public static void main(String[] args) {
        int[] arr = {10, 25, 15, 30, 60, 45, 5, 20};
        int k = 4;

        int num = findKthSmallestElementInUnSortedArray(arr, k);
        System.out.println(k + "ish smallest element in unsorted array is " + num);
    }

    private static int findKthSmallestElementInUnSortedArray(int[] arr, int k) {

        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int j = partition(arr, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                return arr[k-1];
            }
        }
        return arr[k-1];
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

    private static void swap(int[] arr, int i, int r) {
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
    }
}
