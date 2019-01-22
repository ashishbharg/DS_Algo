package edu.ashish.algorithms.search;
/**
 * Program to perform linear search.
 *
 * Time Complexity: O(n)
 */

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 5, 60, 25, 55, 15};
        int key = 25;

        int index = linearSearch(arr, key);

        if (index == -1) {
            System.out.println("Key not found!!!");
        } else {
            System.out.println("Key " + key + " is available at array index " + index);
        }
    }

    private static int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
