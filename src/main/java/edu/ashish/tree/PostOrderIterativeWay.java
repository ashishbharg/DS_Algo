package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

import java.util.Stack;

/**
 * Program to print post order traversal in iterative way. Post order traversal is L, R, V.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) where at one time only one stack will be full with n elements.
 */
public class PostOrderIterativeWay {

    public static void main(String[] args) {

        TreeNode root = DSCreationUtil.createBinaryTree();
        postOrderInIterativeWay(root);
    }

    private static void postOrderInIterativeWay(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if(root == null) {
            return;
        }

        stack1.push(root);
        while(!stack1.empty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.empty()) {
            System.out.print(stack2.pop().getData() + " ");
        }
    }
}
