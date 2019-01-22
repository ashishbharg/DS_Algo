package edu.ashish.tree;

import edu.ashish.model.BalanceTreeNode;
import edu.ashish.util.PrintingUtil;

/**
 * Program to insert and delete onto AVL tree.
 */
public class AVLTree {

    public static void main(String[] args) {

        BalanceTreeNode root = new BalanceTreeNode(40);
        root = insert(root, 50);
        root = insert(root, 60);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 10);
        System.out.println();
        System.out.println("Printing AVL tree after insertion");
        PrintingUtil.printBalanceTree(root);
        root = delete(root, 10);
        root = delete(root, 20);
        System.out.println();
        System.out.println("Printing AVL tree after deleting key 10" );
        PrintingUtil.printBalanceTree(root);
    }

    private static BalanceTreeNode delete(BalanceTreeNode root, int data) {

        // If root is null, return it
        if (root == null) {
            return root;
        }

        // If node to be deleted is less than root, move to left
        if (data < root.data) {
            root.left = delete(root.left, data);
        }
        // If node to be deleted is greater than root, move to right
        else if (data > root.data) {
            root.right = delete(root.right, data);
        }
        // If data matches, then enter else block.
        else {

            BalanceTreeNode temp = null;

            // Check if left or right of node to be deleted is null
            if (root.left == null || root.right == null) {
                // If left side is null, move to right side, else left side
                if (root.left == null) {
                    temp = root.right;
                } else if (root.right == null) {
                    temp = root.left;
                }

                // If temp is null, this means it's a leaf node and can be deleted easily. If not, then we need
                // to move the subtree upwards by removing this node.
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            }
            //If both the child of the deleted node exists, go to this else block.
            else {
                // Find minimum of the right node which is inorder traversal.
                BalanceTreeNode successor = findMin(root.right);
                // set the root's content with this successor
                root.data = successor.data;
                // Delete the node having successor data on the right side.
                root.right = delete(root.right, root.data);
                // Call the setHeight method
                root.height = setHeight(root);
            }
        }

        // If this was the leaf node, return from here.
        if (root == null) {
            return root;
        }

        int balance = getBalance(root);

        // LL case
        if (balance > 1 && getBalance(root.left) >=0) {
            return rightRotate(root);
        }

        // LR case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return  rightRotate(root);
        }

        // RL case
        if (balance < -1 && getBalance(root.right) >=0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // RR case
        if (balance < -1 && getBalance(root.right) < 0) {
            return leftRotate(root);
        }

        return root;
    }

    private static BalanceTreeNode insert(BalanceTreeNode root, int data) {

        if (root == null) {
            return new BalanceTreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        root.height = setHeight(root);

        int treeBalance = balance(root.left, root.right);
        //LL case
        if (treeBalance > 1 && data < root.left.data) {
            return rightRotate(root);
        }
        // RR case
        if (treeBalance < -1 && data > root.right.data) {
            return leftRotate(root);
        }
        // LR case
        if (treeBalance > 1 && data > root.left.data) {
            root.left = rightRotate(root.left);
            return rightRotate(root);
        }
        // RL case
        if (treeBalance < -1 && data < root.right.data) {
            root.right = leftRotate(root.right);
            return rightRotate(root);
        }

        return root;
    }

    private static BalanceTreeNode leftRotate(BalanceTreeNode root) {

        BalanceTreeNode right = root.right;
        BalanceTreeNode leftOfRight = right.left;

        right.left = root;
        root.right = leftOfRight;

        root.height = setHeight(root);
        right.height = setHeight(right);

        return right;
    }

    private static BalanceTreeNode rightRotate(BalanceTreeNode root) {

        BalanceTreeNode left = root.left;
        BalanceTreeNode rightOfLeft = left.right;

        left.right = root;
        root.left = rightOfLeft;

        root.height = setHeight(root);
        left.height = setHeight(left);
        return left;
    }

    private static int getBalance(BalanceTreeNode root) {

        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    private static BalanceTreeNode findMin(BalanceTreeNode node) {

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private static int setHeight(BalanceTreeNode root) {
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static int balance(BalanceTreeNode leftRoot, BalanceTreeNode rightRoot) {

        return height(leftRoot) - height(rightRoot);
    }

    private static int height(BalanceTreeNode root) {

        if (root == null) {
            return 0;
        }

        return root.height;
    }
}
