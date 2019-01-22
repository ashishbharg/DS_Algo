package edu.ashish.algorithms.search;

import java.util.Arrays;

/**
 * Program to perform binary search in iterative way.
 *
 * Time Complexity: O(logN)
 */

public class BinarySearchRecursively {

    public static void main(String[] args) {

        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        int key = 252;

        //For binary search, array has to be sorted.
        Arrays.sort(arr);
        int index = binarySearchRecursively(arr, 0, arr.length - 1, key);

        if (index == -1) {
            System.out.println("Key not found!!!");
        } else {
            System.out.println("Key " + key + " is available at array index " + index);
        }
    }

    private static int binarySearchRecursively(int[] arr, int lo, int hi, int key) {

        if (lo == hi) {
            if (arr[lo] == key) {
                return lo;
            } else {
                return -1;
            }
        } else {
            int mid = (lo + hi) / 2;
            if (key < arr[mid]) {
                return binarySearchRecursively(arr, lo, mid - 1, key);
            } else if (key > arr[mid]) {
                return binarySearchRecursively(arr, mid + 1, hi, key);
            } else {
                return mid;
            }
        }
    }
}
