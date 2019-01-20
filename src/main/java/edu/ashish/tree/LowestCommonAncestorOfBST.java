package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to find lowest common ancestor of binary search tree.
 */
public class LowestCommonAncestorOfBST {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        TreeNode node1 = new TreeNode(30);
        TreeNode node2 = new TreeNode(60);

        TreeNode lowestCommonAncestor = lowestCommonAncestorOfBST(root, node1, node2);
        print(lowestCommonAncestor);

        node1 = new TreeNode(50);
        lowestCommonAncestor = lowestCommonAncestorOfBST(root, node1, node2);
        print(lowestCommonAncestor);

        node1 = new TreeNode(10);
        lowestCommonAncestor = lowestCommonAncestorOfBST(root, node1, node2);
        print(lowestCommonAncestor);
    }

    private static void print(TreeNode lowestCommonAncestor) {
        if (lowestCommonAncestor == null) {
            System.out.println("Tree doesn't have any nodes");
        } else {
            System.out.println("Lowest Common Ancestor is " + lowestCommonAncestor.getData());
        }
    }

    private static TreeNode lowestCommonAncestorOfBST(TreeNode root, TreeNode node1, TreeNode node2) {

        if (root == null) {
            return null;
        }

        if (node1.getData() < root.getData() && node2.getData() < root.getData()) {
            return lowestCommonAncestorOfBST(root.left, node1, node2);
        } else if (node1.getData() > root.getData() && node2.getData() > root.getData()) {
            return lowestCommonAncestorOfBST(root.right, node1, node2);
        } else {
            return root;
        }
    }
}
