package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to print reverse of the linked list without modifying the actual linked list
 */

public class PrintingReverseOfLL {

    private static ListSinglePointerNode root;

    public static void main(String[] args) {
        root = DSCreationUtil.createSinglyLinkedList();
        ListSinglePointerNode.printList(root);
        printReversalOfLL(root);
        System.out.println();
    }

    private static void printReversalOfLL(ListSinglePointerNode head) {

        if(head == null) {
            return;
        }
        printReversalOfLL(head.getNext());
        System.out.print(head.getData());
        if(root != head) {
            System.out.print(" -> ");
        }
    }
}
