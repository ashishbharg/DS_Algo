package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to reverse linked list in pairs. If Linked List is 1->2->3->4->X, then after reverse,
 * linked list should print like 2->1->4->3->X.
 */
public class ReverseLLInPairs {

    public static void main(String[] args) {
        ListSinglePointerNode head = DSCreationUtil.createSinglyLinkedList();
        ListSinglePointerNode.printList(head);
        System.out.println("Recursive Method");
        ListSinglePointerNode result = reverseLLInPairsRecursively(head);
        ListSinglePointerNode.printList(result);
        System.out.println("Iterative Method");
        result = reverseLLInPairsIteratively(result);
        ListSinglePointerNode.printList(result);
    }

    private static ListSinglePointerNode reverseLLInPairsIteratively(ListSinglePointerNode head) {

        ListSinglePointerNode result = null;
        ListSinglePointerNode temp = null;
        // Check if head and next of head is null

        while(head != null && head.getNext() != null) {

            if(temp != null) {
                temp.getNext().setNext(head.getNext());
            }

            temp = head.getNext();
            head.setNext(head.getNext().getNext());
            temp.setNext(head);
            if(result == null) {
                result = temp;
            }
            head = head.getNext();
        }
        return result;
    }

    private static ListSinglePointerNode reverseLLInPairsRecursively(ListSinglePointerNode head) {

        ListSinglePointerNode result = head;
        if(result == null || result.getNext() == null) {
            return result;
        }
        result = head.getNext();
        head.setNext(result.getNext());
        result.setNext(head);
        head = result;
        head.getNext().setNext(reverseLLInPairsRecursively(head.getNext().getNext()));

        return head;
    }
}
