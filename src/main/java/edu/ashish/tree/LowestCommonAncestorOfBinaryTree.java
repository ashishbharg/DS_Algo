package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to find lowest common ancestor of binary tree.
 *
 * Time Complexity: O(n).
 */
public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        TreeNode node1 = new TreeNode(30);
        TreeNode node2 = new TreeNode(60);

        TreeNode node = lowestCommonAncestorOfBinaryTree(root, node1, node2);

        System.out.println("Lowest Common Ancestor of Binary Tree is " + node.data);

    }

    private static TreeNode lowestCommonAncestorOfBinaryTree(TreeNode root, TreeNode node1, TreeNode node2) {

        if (root == null) {
            return null;
        }

        if (root.data == node1.data ||
                root.data == node2.data) {
            System.out.println(root.data);
            return root;
        }

        TreeNode leftCommonAncestor = lowestCommonAncestorOfBinaryTree(root.left, node1, node2);
        TreeNode rightCommonAncestor = lowestCommonAncestorOfBinaryTree(root.right, node1, node2);
        if (leftCommonAncestor != null && rightCommonAncestor != null) {
            return root;
        }

        if (leftCommonAncestor == null && rightCommonAncestor == null) {
            return null;
        }

        return leftCommonAncestor != null ? leftCommonAncestor : rightCommonAncestor;

    }
}
