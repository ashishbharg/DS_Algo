package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Program to find out the branch from root to leaf containing the exact sum.
 */

public class RootToLeafSumBinaryTree {

    public static void main(String[] args) {
        TreeNode root = DSCreationUtil.createBinaryTree();

        List<Integer> result = new LinkedList<>();
        int sum = 170;
        boolean doesBranchExistWithSum = findBranchContainingSum(root, sum, result);

        if(doesBranchExistWithSum) {
            System.out.println("Nodes containing sum " + sum +
                    " are " + result);
        } else {
            System.out.println("No branch exists containing sum");
        }
    }

    private static boolean findBranchContainingSum(TreeNode root, int sum, List<Integer> result) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (root.data == sum) {
                result.add(root.data);
                return true;
            }
            return false;
        }

        if(findBranchContainingSum(root.left, sum - root.data, result)) {
            result.add(root.data);
            return true;
        }
        if (findBranchContainingSum(root.right, sum - root.data, result)) {
           result.add(root.data);
           return true;
        }

        return false;
    }
}
