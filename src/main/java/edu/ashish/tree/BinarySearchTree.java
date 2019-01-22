package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;
import edu.ashish.util.PrintingUtil;

import static edu.ashish.tree.BinarySearchTree.Operation.DELETE;
import static edu.ashish.tree.BinarySearchTree.Operation.INSERT;

/**
 * Program to insert and delete in BST.
 */
public class BinarySearchTree {

    enum Operation {
        INSERT, DELETE
    }

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        System.out.println("Printing initial tree");
        System.out.println();
        PrintingUtil.printTree(root);
        int key = 5;
        root = insertInBST(root, key);
        print(key, INSERT);

        key = 100;
        root = insertInBST(root, key);
        print(key, INSERT);
        PrintingUtil.printTree(root);

        key = 20;
        root = deleteInBST(root, key);
        print(key, DELETE);
        PrintingUtil.printTree(root);
    }

    private static TreeNode deleteInBST(TreeNode root, int key) {

        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left =  deleteInBST(root.left, key);
        } else if (key > root.data) {
            root.right =  deleteInBST(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode successor = minValue(root.right);

            root.data = successor.data;
            root.right = deleteInBST(root.right, successor.data);
        }
        return root;
    }

    /*
       This method call find the inorder of root.right and will be replaced with node to be deleted.
     */
    private static TreeNode minValue(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private static void print(int key, Operation operation) {
        System.out.println();
        if (operation == INSERT) {
            System.out.println("Printing BST after inserting key " + key);
        } else {
            System.out.println("Printing BST after deleting key " + key);
        }
        System.out.println();
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
            if(key >= current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if (key > parent.data) {
            parent.right = node;
        } else {
            parent.left = node;
        }

        return root;
    }
}
