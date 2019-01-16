package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to reverse k blocks in linked list.
 *
 * Example:
 *     Input:  1->2->3->4->5->6->7->8->NULL and k = 3
 *     Output:  3->2->1->6->5->4->8->7->NULL.
 */
public class ReverseKBlocksInLL {

    public static void main(String[] args) {

        ListSinglePointerNode head = DSCreationUtil.createSinglyLinkedList();
        ListSinglePointerNode.printList(head);

        head = reverseKBlocksInLL(head, 4);
        ListSinglePointerNode.printList(head);
    }

    private static ListSinglePointerNode reverseKBlocksInLL(ListSinglePointerNode head, int numberOfBlocks) {

        ListSinglePointerNode next = null;
        ListSinglePointerNode prev = null;
        ListSinglePointerNode current = head;
        int count = 0;

        while(count < numberOfBlocks && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        if(next != null) {
            head.setNext(reverseKBlocksInLL(next, numberOfBlocks));
        }
        return prev;
    }
}
