package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

import java.util.Stack;

/**
 * Program to print pre order traversal in iterative way. Pre Order Traversal is V, L, R
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is the height of binary tree. In worst case, it can be O(n).
 */
public class PreOrderIterativeWay {

    public static void main(String[] args) {
        TreeNode root = DSCreationUtil.createBinaryTree();
        preOrderTraversalUsingIterativeWay(root);
    }

    private static void preOrderTraversalUsingIterativeWay(TreeNode root) {

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.getData() +  " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
