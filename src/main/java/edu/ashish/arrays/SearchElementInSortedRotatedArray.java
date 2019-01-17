package edu.ashish.arrays;

import edu.ashish.util.PrintingUtil;

/**
 * Program to search a given element in sorted and rotated array.
 */
public class SearchElementInSortedRotatedArray {

    public static void main(String[] args) {

        int[] arr = {52, 53, 58, 60, 65, 70, 73, 76, 79, 80, 83, 86, 89, 93, 94, 95,
                11, 12, 15, 18, 20, 23, 27, 30, 35, 40, 45, 46, 48};
        PrintingUtil.print1DArray(arr);

        int num = 11;
        int index = findElementInSortedRotatedArray(arr, num);

        if(index < 0) {
            System.out.println("Element doesn't exists in the array");
        } else {
            System.out.println("Element " + num + " is found at index " + index);
        }
    }

    private static int findElementInSortedRotatedArray(int[] arr, int num) {

        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo <= hi) {

            mid = (lo + hi) / 2;
            if (arr[mid] == num) {
                return mid;
            }

            if (arr[mid] < arr[hi]) {
                if(num > arr[mid] && num <= arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if(arr[lo] <= num && num < arr[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

}
