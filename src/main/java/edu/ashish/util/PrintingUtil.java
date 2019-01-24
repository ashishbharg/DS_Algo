package edu.ashish.util;

import edu.ashish.model.BalanceTreeNode;
import edu.ashish.model.TreeNode;

public class PrintingUtil {

    public static void print1DArray(int[] arr) {

        for(int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void print1DArray(double[] arr) {

        for(double num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void print1DArray(String[] arr) {

        for(String str: arr) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void printTree(TreeNode root) {

        int height = heightOfTree(root);
        for (int i=1; i <= height; i++) {
            printTree(root, i);
            System.out.println();
        }

    }

    public static void printBalanceTree(BalanceTreeNode root) {

        int height = heightOfBalanceTree(root);
        for (int i=1; i <= height; i++) {
            printBalanceTree(root, i);
            System.out.println();
        }

    }

    private static void printBalanceTree(BalanceTreeNode root, int height) {
        if(root == null) {
            return;
        }

        if (height == 1) {
            System.out.print(root.data + "\t");
        } else {
            printBalanceTree(root.left, height - 1);
            printBalanceTree(root.right, height - 1);
        }
    }

    private static int heightOfBalanceTree(BalanceTreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = heightOfBalanceTree(root.left);
        int rHeight = heightOfBalanceTree(root.right);
        return 1 + Integer.max(lHeight, rHeight);
    }

    private static void printTree(TreeNode root, int height) {
        if(root == null) {
            return;
        }

        if (height == 1) {
            System.out.print(root.data + "\t");
        } else {
            printTree(root.left, height - 1);
            printTree(root.right, height - 1);
        }
    }

    private static int heightOfTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = heightOfTree(root.left);
        int rHeight = heightOfTree(root.right);
        return 1 + Integer.max(lHeight, rHeight);
    }

    public static void print2DArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
