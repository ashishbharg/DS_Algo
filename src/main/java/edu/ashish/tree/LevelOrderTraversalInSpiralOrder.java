package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

import java.util.Stack;

/**
 * Program to print level order tree traversal in spiral order.
 */
public class LevelOrderTraversalInSpiralOrder {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        levelOrderTraversalInSpiralOrder(root);
    }

    private static void levelOrderTraversalInSpiralOrder(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.empty() || !stack2.empty()) {
            while (!stack1.empty()) {
                TreeNode node = stack1.pop();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }

            while (!stack2.empty()) {
                TreeNode node = stack2.pop();
                System.out.print(node.data + " ");
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
        }


    }
}
