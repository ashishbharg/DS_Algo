package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to find largest BST in binary tree. Assumption is here that there won't be any duplicates.
 * If duplicates would be there, then this logic would need to be changed.
 *
 * Time Complexity: O(n)
 */
public class LargestBSTInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = DSCreationUtil.createBinaryTree();
        root.left.right = new TreeNode(25);

        int size = largestBSTInBinaryTree(root);
        System.out.println("Size of BST in Binary Tree is: " + size);
    }

    private static int largestBSTInBinaryTree(TreeNode root) {

        NodeData nodeData = largestBST(root);
        System.out.println(nodeData);
        return nodeData.size;
    }

    private static NodeData largestBST(TreeNode root) {

        if (root == null) {
            return new NodeData();
        }

        NodeData leftNodeData = largestBST(root.left);
        NodeData rightNodeData = largestBST(root.right);

        NodeData nodeData = new NodeData();

        if(root.left == null) {
            leftNodeData.max = root.getData();
        }

        if (root.right == null) {
            rightNodeData.min = root.getData();
        }
        if (leftNodeData.isBST == false || rightNodeData.isBST == false
                || (leftNodeData.max > root.getData() || rightNodeData.min < root.getData())) {
            nodeData.isBST = false;
            nodeData.size = Math.max(leftNodeData.size, rightNodeData.size);
            return nodeData;
        }

        nodeData.isBST = true;
        nodeData.size = leftNodeData.size + rightNodeData.size + 1;
        nodeData.min = root.left != null ? leftNodeData.min : root.getData();
        nodeData.max = root.right != null ? rightNodeData.max : root.getData();

        return nodeData;
    }
}

class NodeData {

    int min;
    int max;
    boolean isBST;
    int size;

    NodeData() {
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
        isBST = true;
        size = 0;
    }

    @Override
    public String toString() {
        return "NodeData [" +
                " min: " + min +
                ", max: " + max +
                ", isBST: " + isBST +
                ", size: " + size + " ]";
    }
}
