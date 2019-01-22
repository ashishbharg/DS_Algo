package edu.ashish.algorithms.search;

import java.util.Arrays;

/**
 * Program to perform binary search in iterative way.
 *
 * Time Complexity: O(logN)
 */
public class BinarySearchIteratively {

    public static void main(String[] args) {

        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        int key = 25;

        //For binary search, array has to be sorted.
        Arrays.sort(arr);
        int index = binarySearch(arr, key);

        if (index == -1) {
            System.out.println("Key not found!!!");
        } else {
            System.out.println("Key " + key + " is available at array index " + index);
        }
    }

    private static int binarySearch(int[] arr, int key) {

        int lo = 1;
        int hi = arr.length;
        int mid;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if(arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
