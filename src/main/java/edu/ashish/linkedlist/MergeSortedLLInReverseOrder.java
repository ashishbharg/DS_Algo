package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to merge two sorted linked lists in reverse order.
 * Ex. Input:  a: 5->10->15->40
 *         b: 2->3->20
 *     Output: res: 40->20->15->10->5->3->2
 */

public class MergeSortedLLInReverseOrder {

    public static void main(String[] args) {

        ListSinglePointerNode head1 = DSCreationUtil.createSortedSinglyLinkedList(1, 2, 5, 10, 15, 20);
        ListSinglePointerNode head2 = DSCreationUtil.createSortedSinglyLinkedList(3, 12, 18, 23, 27, 30);
        ListSinglePointerNode.printList(head1);
        ListSinglePointerNode.printList(head2);

        ListSinglePointerNode result = mergeSortedLLInReverseOrder(head1, head2);
        ListSinglePointerNode.printList(result);
    }

    private static ListSinglePointerNode mergeSortedLLInReverseOrder(ListSinglePointerNode head1,
                                                                     ListSinglePointerNode head2) {

        ListSinglePointerNode result = null;
        ListSinglePointerNode current1 = head1;
        ListSinglePointerNode current2 = head2;
        ListSinglePointerNode temp = null;

        if(current1 == null && current2 == null) {
            return result;
        }

        while(current1 != null && current2 != null) {

            if(current1.getData() <= current2.getData()) {
                temp = current1;
                current1 = current1.getNext();
            } else {
                temp = current2;
                current2 = current2.getNext();
            }
            temp.setNext(result);
            result = temp;
        }

        while(current1 != null) {
            temp = current1;
            current1 = current1.getNext();
            temp.setNext(result);
            result = temp;
        }

        while(current2 != null) {
            temp = current2;
            current2 = current2.getNext();
            temp.setNext(result);
            result = temp;
        }

        return result;
    }
}
