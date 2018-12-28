package edu.ashish.util;

import edu.ashish.model.ListSinglePointerNode;

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
        return head;
    }

    public static ListSinglePointerNode createSortedSinglyLinkedList() {
        ListSinglePointerNode head = new ListSinglePointerNode(1);
        ListSinglePointerNode node1 = new ListSinglePointerNode(3);
        head.setNext(node1);
        ListSinglePointerNode node2 = new ListSinglePointerNode(5);
        node1.setNext(node2);
        ListSinglePointerNode node3 = new ListSinglePointerNode(7);
        node2.setNext(node3);
        ListSinglePointerNode node4 = new ListSinglePointerNode(8);
        node3.setNext(node4);
        ListSinglePointerNode node5 = new ListSinglePointerNode(9);
        node4.setNext(node5);
        return head;
    }
}
