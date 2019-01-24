package edu.ashish.heap;

import edu.ashish.util.PrintingUtil;

/**
 * Program to insert and delete values in heap data structure.
 *
 * Time Complexity: Insertion O(logn)
 * Time Complexity: Deletion O(logn)
 */
public class HeapOperations {

    private static int N = 0;

    private static int[] arr;

    public HeapOperations(int heapSize) {
        arr = new int[heapSize];
    }

    public static void main(String[] args) {

        new HeapOperations(12);
        insertInHeap(20);
        PrintingUtil.print1DArray(arr);
        insertInHeap(30);
        PrintingUtil.print1DArray(arr);
        insertInHeap(40);
        PrintingUtil.print1DArray(arr);
        insertInHeap(50);
        PrintingUtil.print1DArray(arr);
        insertInHeap(60);
        PrintingUtil.print1DArray(arr);
        insertInHeap(70);
        PrintingUtil.print1DArray(arr);
        insertInHeap(10);
        PrintingUtil.print1DArray(arr);
        insertInHeap(100);
        PrintingUtil.print1DArray(arr);
        int max = deleteMax();
        System.out.println("Maximum element is " + max);
        PrintingUtil.print1DArray(arr);
        max = deleteMax();
        System.out.println("Maximum element is " + max);
        PrintingUtil.print1DArray(arr);
        max = deleteMax();
        System.out.println("Maximum element is " + max);
        PrintingUtil.print1DArray(arr);
    }

    private static int deleteMax() {

        int max = arr[0];
        arr[0] = arr[--N];
        sink(0);
        arr[N] = 0;
        return max;
    }

    private static void sink(int index) {

        while (2 * index <= N) {
            int childIndex = 2 * index + 1;
            if (childIndex <= N && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++;
            } else if (arr[index] > arr[childIndex]) {
                break;
            }
            int temp = arr[index];
            arr[index] = arr[childIndex];
            arr[childIndex] = temp;
            index = childIndex;
        }
    }

    private static void insertInHeap(int data) {

        arr[N] = data;
        swim(N);
        N++;
    }

    private static void swim(int index) {

        int parentIndex = (index - 1) / 2;
        while (index > 0 && arr[index] > arr[parentIndex]) {
            int temp = arr[index];
            arr[index] = arr[parentIndex];
            arr[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
}
