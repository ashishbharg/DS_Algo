package edu.ashish.algorithms.sort;

import edu.ashish.util.PrintingUtil;

import java.util.Arrays;

/**
 * Radix Sort. It uses counting sort internally to sort the elements. For simplicity, took integers as input array.
 * For other values, the range can be more than 10 in which case the bucket size of counting sort will be increased.
 */
public class RadixSort {

    public static void main(String[] args) {

        int[] arr = {16, 8, 103, 117, 71, 58, 13, 116};
        System.out.println("Before sorting");
        PrintingUtil.print1DArray(arr);
        radixSort(arr);
        System.out.println("After sorting");
        PrintingUtil.print1DArray(arr);
    }

    private static void radixSort(int[] arr) {

        int N = arr.length;
        int maxNumber = Arrays.stream(arr).max().getAsInt();

        for (int i = 1; maxNumber / i > 0; i *=10) {
            countSort(arr, N, i);
        }
    }

    private static void countSort(int[] arr, int n, int k) {

        int[] res = new int[n];
        int[] aux = new int[10];

        for (int i = 0; i < arr.length; i++) {
            aux[(arr[i] / k) % 10]++;
        }

        for (int i = 1; i < aux.length; i++) {
            aux[i] = aux[i - 1] + aux[i];
        }

        for (int i = arr.length - 1; i >=0; i--) {
            res[aux[(arr[i] / k) % 10] - 1] = arr[i];
            aux[(arr[i] / k) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }

    }
}
