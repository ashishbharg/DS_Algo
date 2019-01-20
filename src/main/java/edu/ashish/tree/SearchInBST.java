package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to search in Binary Search Tree.
 */
public class SearchInBST {

    public static void main(String[] args) {
        TreeNode root = DSCreationUtil.createBinaryTree();

        int key = 60;
        TreeNode node = searchInBST(root, key);
        print(node, key);

        key = 45;
        node = searchInBST(root, key);
        print(node, key);

    }

    private static TreeNode searchInBST(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.getData() == key) {
            return root;
        } else if (key > root.getData()) {
            return searchInBST(root.right, key);
        } else {
            return searchInBST(root.left, key);
        }
    }

    private static void print(TreeNode node, int key) {
        if (node == null) {
            System.out.println(key + " doesn't exists in tree");
        } else {
            System.out.println(key + " exists in tree");
        }
    }
}
