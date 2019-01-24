package edu.ashish.matrix;

import edu.ashish.util.PrintingUtil;

/**
 * Program to print array in spiral form.
 *
 * Algorithm is to print the border of the matrix and then decrement the array size by 1 and repeat the same
 * process to print the boundary of inner matrix and so on.
 *
 * Time Complexity: O(mn)
 */
public class PrintMatrixInSpiralForm {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };

        PrintingUtil.print2DArray(arr);

        int rowLength = arr.length;
        int colLength = arr[0].length;

        System.out.println();
        System.out.println("Column length is " + colLength);
        System.out.println("Row length is " + rowLength);

        System.out.println("Printing matrix in spiral form");
        printMatrixInSpiralForm(arr, colLength, rowLength);
    }

    private static void printMatrixInSpiralForm(int[][] arr, int colLength, int rowLength) {

        int j = 0; //starting row index
        int k = 0; // starting col index

        while (j < rowLength && k < colLength) {

            for (int i = k; i < colLength; i++) {
                System.out.print(arr[j][i] + " ");
            }
            j++;

            for (int i = j; i < rowLength; i++) {
                System.out.print(arr[i][colLength - 1] + " ");
            }
            colLength--;

            if (j < rowLength) {
                for (int i = colLength - 1; i >= k; i--) {
                    System.out.print(arr[rowLength - 1][i] + " ");
                }
                rowLength--;
            }

            if (k < colLength) {
                for (int i = rowLength - 1; i >= j; i--) {
                    System.out.print(arr[i][k] + " ");
                }
                k++;
            }
        }
    }
}
