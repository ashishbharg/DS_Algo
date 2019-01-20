package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

public class SizeOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        int size = sizeOfBinaryTree(root);
        System.out.println("Size of binary tree is " + size);
    }

    private static int sizeOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSize = sizeOfBinaryTree(root.left);
        int rightSize = sizeOfBinaryTree(root.right);
        return 1 + leftSize + rightSize;
    }
}
