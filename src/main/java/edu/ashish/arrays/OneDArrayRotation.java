package edu.ashish.arrays;

import edu.ashish.util.PrintingUtil;

/**
 * Program to rotate 1-D array by given number. This program uses multiple approaches for rotating arrays.
 * 1. Rotation one by one. Time Complexity - O(n*d)
 * 2. Jugglers algorithm (Makes use of GCD/HCF). Time Complexity - O(n)
 * 3. Reversal algorithm. Time Complexity - O(n)
 *
 * Example
 *     Input: arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2
 *     Output: arr[] = [3, 4, 5, 6, 7, 1, 2]
 */
public class OneDArrayRotation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Initial Array");
        PrintingUtil.print1DArray(arr);
        int rotateCount = 2;

        System.out.println("Rotation using rotating elements one by one");
        arrayRotateOneByOneApproach(arr, rotateCount);
        PrintingUtil.print1DArray(arr);

        System.out.println("Rotation using juggling algorithm");
        arrayRotateByJugglingAlgorithm(arr, 3);
        PrintingUtil.print1DArray(arr);

        System.out.println("Rotation using reversal algorithm");
        arrayRotateByReversalAlgorithm(arr, 2);
        PrintingUtil.print1DArray(arr);
    }

    private static void arrayRotateByReversalAlgorithm(int[] arr, int rotateCount) {

        reverse(arr, 0, rotateCount - 1);
        reverse(arr, rotateCount, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {

        while(start < end) {
            swap(arr, start, end);
            start ++;
            end --;
        }
    }

    private static void swap(int[] arr, int start, int end) {

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static void arrayRotateByJugglingAlgorithm(int[] arr, int rotateCount) {

        int i, j, k, temp;

        for (i = 0; i < gcd(rotateCount, arr.length); i++) {
            temp = arr[i];
            j = i;

            while(true) {
                k = (j + rotateCount) % arr.length;
                if(k == i) {
                    break;
                }

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /**
     * This gcd algorithm is based on Euclidian algorithm
     *
     * @see https://www.youtube.com/watch?v=JUzYl1TYMcU
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {

        if(b == 0) {
            return a;
        } else {
            return gcd (b, a % b);
        }
    }

    private static int gcd_v2(int a, int b) {

        while (a != b) {
            if( a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    private static void arrayRotateOneByOneApproach(int[] arr, int rotateCount) {

        int temp;
        int j;
        for(int i = 0; i < rotateCount; i++) {
            temp = arr[0];
            for (j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
        }
    }
}
