package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

public class OrderTraversals {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();

        System.out.println("Pre Order Traversal");
        preOrder(root);
        System.out.println();

        System.out.println("In Order Traversal");
        inOrder(root);
        System.out.println();

        System.out.println("Post Order Traversal");
        postOrder(root);
        System.out.println();

        System.out.println("Level Order Traversal");
        levelOrder(root);
        System.out.println();
    }

    private static void levelOrder(TreeNode root) {

        int height = heightOfTree(root);

        for (int i = 1; i <= height; i++) {
            levelOrder(root, i);
            System.out.println();
        }
        System.out.println();
    }


    private static void levelOrder(TreeNode root, int height) {

        if (root == null) {
            return;
        }
        if (height == 1) {
            System.out.print(root.getData() + " ");
        } else {
            levelOrder(root.left, height - 1);
            levelOrder(root.right, height - 1);
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

    private static void postOrder(TreeNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.getData() + "  ");
        }
    }

    private static void inOrder(TreeNode root) {

        if(root != null) {
            inOrder(root.left);
            System.out.print(root.getData() + "  ");
            inOrder(root.right);
        }
    }

    private static void preOrder(TreeNode root) {

        if (root != null) {
            System.out.print(root.getData() + "  ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
