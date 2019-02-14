package edu.ashish.heap;

public class IsGivenArrayHeap {

    public static void main(String[] args) {

        int[] arr = {4, 3, 1, 2};
        boolean result = isGivenArrayHeap(arr);
        System.out.println(result);
    }

    private static boolean isGivenArrayHeap(int[] arr) {

        int N = arr.length;
        int index = N / 2;
        while (index > 0) {
            if(!isSubArrayHeap(arr, index, N)) {
                return false;
            }
            index--;
        }
        return true;
    }

    private static boolean isSubArrayHeap(int[] arr, int index, int arrayLength) {

        int childIndex = 2 * index;

        if (childIndex >= arrayLength) {
            return true;
        }
        if (childIndex < arrayLength && arr[childIndex - 1] < arr[childIndex]) {
            childIndex++;
        }

        if (arr[index - 1] < arr[childIndex - 1]) {
            return false;
        }
        return true;
    }
}
