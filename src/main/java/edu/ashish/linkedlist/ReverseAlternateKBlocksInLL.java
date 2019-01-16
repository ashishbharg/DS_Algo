package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Reverse Alternate K blocks in Linked List.
 * Example:
 *   Input:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 *   Output:   3->2->1->4->5->6->9->8->7->NULL.
 */
public class ReverseAlternateKBlocksInLL {

    public static void main(String[] args) {

        ListSinglePointerNode head = DSCreationUtil.createSinglyLinkedList();
        ListSinglePointerNode.printList(head);

        head = reverseAlternateKBlocksInLL(head, 2);
        ListSinglePointerNode.printList(head);

    }

    private static ListSinglePointerNode reverseAlternateKBlocksInLL(ListSinglePointerNode head, int numberOfBlocks) {

        ListSinglePointerNode current = head;
        ListSinglePointerNode prev = null;
        ListSinglePointerNode next = null;
        int count = 0;

        while(count < numberOfBlocks && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        if(current != null) {
            head.setNext(current);
        }

        count = 0;
        while(count < numberOfBlocks - 1 && current != null) {
            current = current.getNext();
            count++;
        }

        if(current != null) {
            current.setNext(reverseAlternateKBlocksInLL(current.getNext(), numberOfBlocks));
        }

        return prev;
    }
}
