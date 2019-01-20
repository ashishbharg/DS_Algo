package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;
import edu.ashish.util.PrintingUtil;

public class InsertionInBST {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        int key = 5;
        root = insertInBST(root, key);

        PrintingUtil.printTree(root);

        key = 100;
        root = insertInBST(root, key);
        PrintingUtil.printTree(root);
    }

    public static TreeNode insertInBST(TreeNode root, int key) {

        TreeNode node = new TreeNode(key);
        if (root == null) {
            return node;
        }
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            parent = current;
            if(key >= current.getData()) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if (key > parent.getData()) {
            parent.right = node;
        } else {
            parent.left = node;
        }

        return root;
    }
}
