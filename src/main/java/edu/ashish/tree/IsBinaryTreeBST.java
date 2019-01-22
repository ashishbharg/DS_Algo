package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to find out if binary tree is BST or not.
 */
public class IsBinaryTreeBST {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();

        boolean isBinaryBST = isBinaryBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        print(isBinaryBST);

        root.left.right = new TreeNode(25);
        isBinaryBST = isBinaryBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        print(isBinaryBST);

    }

    private static boolean isBinaryBST(TreeNode root, int min, int max) {

        if (root == null) {
            return true;
        }

        if(root.data <= min || root.data > max) {
            return false;
        }

        return isBinaryBST(root.left, min, root.data) &&
                isBinaryBST(root.right, root.data, max);
    }

    private static void print(boolean isBinaryBST) {
        if (isBinaryBST) {
            System.out.println("Binary Tree is BST");
        } else {
            System.out.println("Binary Tree is not BST");
        }
    }
}
