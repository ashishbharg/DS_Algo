package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

import java.util.Stack;

/**
 * Program to print in-order traversal iteratively. In Order traversal is L,V,R
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is the height of binary tree. In worst case, it can be O(n).
 *
 */
public class InOrderIterativeWay {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        inOrderTraversalIteratively(root);
    }

    private static void inOrderTraversalIteratively(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.empty()) {
                    break;
                }
                root = stack.pop();
                System.out.print(root.getData() + " ");
                root = root.right;
            }
        }
    }
}
