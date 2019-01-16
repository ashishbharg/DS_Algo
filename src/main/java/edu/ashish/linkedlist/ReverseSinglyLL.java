package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to find out the reverse of single linked list.
 */

public class ReverseSinglyLL {

    public static void main(String[] args) {

        ListSinglePointerNode head = DSCreationUtil.createSinglyLinkedList();
        ListSinglePointerNode.printList(head);
        head = reverseLL(head);
        ListSinglePointerNode.printList(head);
    }

    private static ListSinglePointerNode reverseLL(ListSinglePointerNode head) {

        ListSinglePointerNode newNode = null;
        ListSinglePointerNode tempNode;

        while(head != null) {
            tempNode = head;
            head = head.getNext();
            tempNode.setNext(null);
            if(newNode == null) {
                newNode = tempNode;
            } else {
                tempNode.setNext(newNode);
                newNode = tempNode;
            }
        }
        return newNode;
    }
}
