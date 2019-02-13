package edu.ashish.heap;

import edu.ashish.util.PrintingUtil;

public class MinimumSumFormedByDigits {

    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3};

        int sum = minimumSumFormedByDigits(arr);
        System.out.println("Minimum sum of two numbers formed by array is : " + sum);
    }

    private static int minimumSumFormedByDigits(int[] arr) {

        createHeap(arr);

        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            exch(arr, 1, n--);
            sink(arr, 1, n);
        }
        int a = 0, b = 0;

        PrintingUtil.print1DArray(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                a = arr[i] + a * 10;
            } else {
                b = arr[i] + b * 10;
            }
        }
        System.out.println("Minimum nos formed from array are: " + a + ", " + b);
        return a + b;
    }

    private static void createHeap(int[] arr) {

        int N = arr.length;
        int index = N / 2;
        while (index > 0) {
            sink(arr, index, N);
            index--;
        }
    }

    private static void sink(int[] arr, int index, int arrLength) {

        int childIndex = 2 * index;
        while (childIndex < arrLength) {
            if (childIndex < arrLength && arr[childIndex - 1] < arr[childIndex]) {
                childIndex++;
            }
            if (arr[index - 1] < arr[childIndex - 1]) {
                exch(arr, index, childIndex);
            } else {
                break;
            }
            index = childIndex;
            childIndex = 2 * index;
        }
    }

    private static void exch(int[] arr, int index, int childIndex) {
        int temp = arr[index - 1];
        arr[index - 1] = arr[childIndex - 1];
        arr[childIndex - 1] = temp;
    }
}
