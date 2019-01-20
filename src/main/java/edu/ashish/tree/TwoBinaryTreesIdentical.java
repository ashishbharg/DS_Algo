package edu.ashish.tree;

import edu.ashish.model.TreeNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to determine if two trees are identical or not.
 */
public class TwoBinaryTreesIdentical {

    public static void main(String[] args) {
        TreeNode root1 = DSCreationUtil.createBinaryTree();
        TreeNode root2 = DSCreationUtil.createBinaryTree();


        boolean areTwoTreesIdentical = areTwoBinaryTreesIdentical(root1, root2);
        print(areTwoTreesIdentical);

        root2 = InsertionInBST.insertInBST(root2, 100);
        areTwoTreesIdentical = areTwoBinaryTreesIdentical(root1, root2);
        print(areTwoTreesIdentical);
    }

    private static void print(boolean areTwoTreesIdentical) {
        if(areTwoTreesIdentical) {
            System.out.println("Two trees are identical");
        } else {
            System.out.println("Two trees are not identical");
        }
    }

    private static boolean areTwoBinaryTreesIdentical(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        return root1.getData() == root2.getData() &&
                areTwoBinaryTreesIdentical(root1.left, root2.left) &&
                areTwoBinaryTreesIdentical(root1.right, root2.right);
    }
}
