package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to find the height of binary tree.
 */
public class HeightOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        int height = heightOfBinaryTree(root);
        System.out.println("Height of binary tree is " + height);
    }

    private static int heightOfBinaryTree(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int lHeight = heightOfBinaryTree(root.left);
        int rHeight = heightOfBinaryTree(root.right);
        return 1 + Math.max(lHeight, rHeight);
    }
}
