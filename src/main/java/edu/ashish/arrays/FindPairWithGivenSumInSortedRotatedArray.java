package edu.ashish.arrays;

import edu.ashish.util.PrintingUtil;

/**
 * Program to find pair with given sum in sorted and rotated array. Assumption is that elements in array are unique.
 *
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class FindPairWithGivenSumInSortedRotatedArray {

    public static void main(String[] args) {

        int[] arr = {52, 53, 58, 60, 65, 70, 73, 76, 79, 80, 83, 86, 89, 93, 94, 95,
                11, 12, 15, 18, 20, 23, 27, 30, 35, 40, 45, 46, 48};
        PrintingUtil.print1DArray(arr);

        int sum = 159;
        int[] result = findPairWithGivenSumInSortedRotatedArray(arr, sum);
        if(result.length == 0) {
            System.out.println("No pair exists for given sum");
        } else {
            System.out.println("Pair [" + result[0] + ", " + result[1] + "] exists for a given sum");
        }
    }

    private static int[] findPairWithGivenSumInSortedRotatedArray(int[] arr, int sum) {

        int maximumElementIndex = findMaximumElementIndex(arr);
        System.out.println("Maximum element is found at index " + maximumElementIndex);

        int lo;
        int hi;
        int arrLength = arr.length - 1;
        int[] result = {};

        //Before setting lo and hi, need to check if array is already sorted without any rotation.
        if(maximumElementIndex == arrLength) {
            lo = 0;
            hi = arrLength;
        } else {
            hi = maximumElementIndex;
            lo = maximumElementIndex + 1;
        }

        while (lo != hi) {
            //If sum of elements at lo and hi equal to sum, return with elements at those indexes.
            if (arr[lo] + arr[hi] == sum) {
                result = new int[2];
                result[0] = arr[lo];
                result[1] = arr[hi];
                return result;
            }
            // If sum of two indices is less than sum, then increment lo.
            else if (arr[lo] + arr[hi] < sum) {
                // In case of rotated array, if lo has reached the array length then need to set to start of array.
                if (lo == arrLength) {
                    lo = 0;
                } else {
                    lo++;
                }
            }
            // If sum of two indices is greater than sum, then decrement hi.
            else if (arr[lo] + arr[hi] > sum) {
                // In case of rotated array, if hi has reached the start of array then need to set to array length - 1.
                if (hi == 0) {
                    hi = arrLength;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }

    private static int findMaximumElementIndex(int[] arr) {

        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        // If there is only one element, return with it.
        if(lo == hi) {
            return lo;
        }

        // If array s already sorted, return with end index of array
        if(arr[lo] < arr[hi]) {
            return hi;
        }

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            // Check if arr[mid] is the largest element. Right to this element would be smaaler than mid.
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // Check if arr[mid] is lower than left element, then left element is the largest element.
            else if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            //If arr[mid] is less than arr[lo], then highest element is on left subarray.
            else if (arr[mid] < arr[lo]) {
                hi = mid - 1;
            }
            //If arr[mid] is greater than arr[hi], then highest element is on right subarray.
            else if (arr[mid] > arr [hi]) {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
