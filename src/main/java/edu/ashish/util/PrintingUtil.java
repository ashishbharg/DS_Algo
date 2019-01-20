package edu.ashish.util;

import edu.ashish.model.TreeNode;

public class PrintingUtil {

    public static void print1DArray(int[] arr) {

        for(int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printTree(TreeNode root) {

        int height = heightOfTree(root);
        for (int i=1; i < height; i++) {
            printTree(root, i);
            System.out.println();
        }

    }

    private static void printTree(TreeNode root, int height) {
        if(root == null) {
            return;
        }

        if (height == 1) {
            System.out.print(root.getData() + "\t");
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
}
