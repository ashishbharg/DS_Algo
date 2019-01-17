package edu.ashish.arrays;

import edu.ashish.util.PrintingUtil;

/**
 * Determine how many times sorted array is rotated.
 *
 * Time Complexity - O(logN)
 */
public class TimesSortedArrayIsRotated {

    public static void main(String[] args) {

        int[] arr = {52, 53, 58, 60, 65, 70, 73, 76, 79, 80, 83, 86, 89, 93, 94, 95,
                11, 12, 15, 18, 20, 23, 27, 30, 35, 40, 45, 46, 48};
        PrintingUtil.print1DArray(arr);

        int count = findNoOfTimesSortedArrayIsRotated(arr);
        System.out.println(count + " number of times sorted array is rotated.");
    }

    private static int findNoOfTimesSortedArrayIsRotated(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            if(arr[low] <= arr[high]) {
                return low;
            }
            mid = (low + high) / 2;
            int prev = mid - 1;
            int next = mid + 1;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            } else if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            }
        }

        return -1;
    }
}
