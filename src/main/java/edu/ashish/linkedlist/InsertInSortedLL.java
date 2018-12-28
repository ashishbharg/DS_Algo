package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

public class InsertInSortedLL {

    public static void main(String[] args) {

        ListSinglePointerNode head = DSCreationUtil.createSortedSinglyLinkedList();
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
