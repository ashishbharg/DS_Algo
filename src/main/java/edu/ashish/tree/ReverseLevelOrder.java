package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Program to print level order traversal in reverse order.
 */

public class ReverseLevelOrder {

    public static void main(String[] args) {
        TreeNode root = DSCreationUtil.createBinaryTree();
        reverseLevelOrder(root);
    }

    private static void reverseLevelOrder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            stack.push(node);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop().data + " ");
        }
    }
}
