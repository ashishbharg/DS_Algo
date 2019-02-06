package edu.ashish.util;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.model.TreeNode;
import sun.reflect.generics.tree.Tree;

public class DSCreationUtil {

    public static ListSinglePointerNode createSingularCircularList() {
        ListSinglePointerNode head = new ListSinglePointerNode(5);
        ListSinglePointerNode node1 = new ListSinglePointerNode(8);
        head.setNext(node1);
        ListSinglePointerNode node2 = new ListSinglePointerNode(3);
        node1.setNext(node2);
        ListSinglePointerNode node3 = new ListSinglePointerNode(7);
        node2.setNext(node3);
        ListSinglePointerNode node4 = new ListSinglePointerNode(1);
        node3.setNext(node4);
        ListSinglePointerNode node5 = new ListSinglePointerNode(9);
        node4.setNext(node5);
        node5.setNext(head);
        return head;
    }

    public static ListSinglePointerNode createLoopInLinkedList() {
        ListSinglePointerNode head = new ListSinglePointerNode(5);
        ListSinglePointerNode node1 = new ListSinglePointerNode(8);
        head.setNext(node1);
        ListSinglePointerNode node2 = new ListSinglePointerNode(3);
        node1.setNext(node2);
        ListSinglePointerNode node3 = new ListSinglePointerNode(7);
        node2.setNext(node3);
        ListSinglePointerNode node4 = new ListSinglePointerNode(1);
        node3.setNext(node4);
        ListSinglePointerNode node5 = new ListSinglePointerNode(9);
        node4.setNext(node5);
        node5.setNext(node2);
        return head;
    }

    public static ListSinglePointerNode createSinglyLinkedList() {
        ListSinglePointerNode head = new ListSinglePointerNode(5);
        ListSinglePointerNode node1 = new ListSinglePointerNode(8);
        head.setNext(node1);
        ListSinglePointerNode node2 = new ListSinglePointerNode(3);
        node1.setNext(node2);
        ListSinglePointerNode node3 = new ListSinglePointerNode(7);
        node2.setNext(node3);
        ListSinglePointerNode node4 = new ListSinglePointerNode(1);
        node3.setNext(node4);
        ListSinglePointerNode node5 = new ListSinglePointerNode(9);
        node4.setNext(node5);
        ListSinglePointerNode node6 = new ListSinglePointerNode(4);
        node5.setNext(node6);
        ListSinglePointerNode node7 = new ListSinglePointerNode(6);
        node6.setNext(node7);
        return head;
    }

    public static ListSinglePointerNode createSortedSinglyLinkedList(int data1, int data2, int data3,
                                                                     int data4, int data5, int data6) {
        ListSinglePointerNode head = new ListSinglePointerNode(data1);
        ListSinglePointerNode node1 = new ListSinglePointerNode(data2);
        head.setNext(node1);
        ListSinglePointerNode node2 = new ListSinglePointerNode(data3);
        node1.setNext(node2);
        ListSinglePointerNode node3 = new ListSinglePointerNode(data4);
        node2.setNext(node3);
        ListSinglePointerNode node4 = new ListSinglePointerNode(data5);
        node3.setNext(node4);
        ListSinglePointerNode node5 = new ListSinglePointerNode(data6);
        node4.setNext(node5);
        return head;
    }

    public static TreeNode createBinaryTree() {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(40);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(50);
        root.right.right.right = new TreeNode(60);
        return root;
    }
}
