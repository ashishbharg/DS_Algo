package edu.ashish.arrays;

import edu.ashish.util.PrintingUtil;

/**
 * Find maximum value of sum (i*arr[i]) with only rotations on given array allowed
 *
 * Algo: This is based on mathematical calculation
 *
 * R0 = 0.a[0] + 1.a[1] + 2.a[2] + .... + (n-1).a[n-1]
 * R1 = 0.a[n-1] + 1.a[0] + 2.a[1] + .... + (n-1).a[n-2]
 * R2 = 0.a[n-2] + 1.a[n-1] + 2.a[0] + .... + (n-1).a[n-3]
 * R1 - R0 = a[0] + a[1] + a[2] + .... + (n-1).a[n-2] - (n-1).a[n-1]
 * R2 - R1 = a[0] + a[1] + a[2] + .... + a[n-3] - (n-1).a[n-2] + a[n-1]
 * .
 * .
 * Rj - Rj-1 = a[0] + a[1] + a[2] + .... + a[n-3] + a[n-2] + a[n-1] - n.a[n-j] (Afer expanding (n-1).a[n-j])
 *           = arrSum - n * a[n-j]
 * Rj = Rj-1 + arrSum - n * a[n-j]
 * where arrSum = sum of elements in array
 *  and  Rj-1 = sum of (i*arr[i]) taken as initial sum of elements with index.
 */
public class MaximumSumFromRotations {

    public static void main(String[] args) {

        int[] arr = {10, 2, 1, 20};
//        int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        PrintingUtil.print1DArray(arr);

        int sum = findMaxSumFromArrayRotations(arr);
        System.out.println("Maximum sum from array rotation is " + sum);
    }

    private static int findMaxSumFromArrayRotations(int[] arr) {

        int arrsum = 0;
        int currVal = 0;

        for(int i = 0; i < arr.length; i++) {
            arrsum += arr[i];
            currVal += (i * arr[i]);
        }

        int maxVal = currVal;

        for (int i = 1; i < arr.length; i++) {
            currVal = currVal + arrsum - arr.length * arr[arr.length - i];

            if (currVal > maxVal) {
                maxVal = currVal;
            }
        }
        return maxVal;
    }

}
