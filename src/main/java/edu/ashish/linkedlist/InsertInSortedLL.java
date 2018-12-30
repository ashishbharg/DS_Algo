package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to insert in sorted linked list
 */

public class InsertInSortedLL {

    public static void main(String[] args) {

        ListSinglePointerNode head = DSCreationUtil.createSortedSinglyLinkedList(1, 3, 5, 7, 8, 9);
        ListSinglePointerNode.printList(head);
        ListSinglePointerNode newNode = new ListSinglePointerNode(6);
        head = insertInSortedLL(newNode, head);
        ListSinglePointerNode.printList(head);
    }

    private static ListSinglePointerNode insertInSortedLL(ListSinglePointerNode newNode, ListSinglePointerNode head) {

        ListSinglePointerNode currentNode = head;
        ListSinglePointerNode prevNode = head;
        while(currentNode != null && currentNode.getData() < newNode.getData()) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
        return head;
    }
}
