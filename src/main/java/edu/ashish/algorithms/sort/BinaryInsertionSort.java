package edu.ashish.algorithms.sort;

import static edu.ashish.util.PrintingUtil.print1DArray;

/**
 * Binary Insertion Sort. This is an improved version of insertion sort where the number of compares will be less
 * as compares are costly than exchanges. Using binary search, find out the index till when the element needs to be
 * inserted. Instead of n compares, it will perform log(n) compares. However, if list is reverse sorted then the
 * time complexity will be O(n^2)
 *
 * Average time complexity will be O(nlogn).
 */
public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        System.out.println("Before sorting");
        print1DArray(arr);
        binaryInsertionSort(arr);
        System.out.println("After sorting");
        print1DArray(arr);
    }

    private static void binaryInsertionSort(int[] arr) {

        int N = arr.length;

        for (int i = 1; i < N; i++) {
            int temp = arr[i];
            int lo = 0;
            int hi = i;

            while ( lo < hi) {

                int mid = (lo + hi) / 2;
                if (arr[mid] < temp) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            for (int j = i; j > lo; --j) {
                arr[j] = arr[j - 1];
            }
            arr[lo] = temp;
        }
    }
}
