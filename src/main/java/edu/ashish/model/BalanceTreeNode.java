package edu.ashish.model;

public class BalanceTreeNode {

    public int data;

    public BalanceTreeNode left;

    public BalanceTreeNode right;

    public int height;

    public BalanceTreeNode(int data) {
        this.data = data;
        this.height = 1;
    }
}
