package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Merge Two Sorted Linked List into one Linked List.
 */
public class MergeSortedLL {

    public static void main(String[] args) {
        ListSinglePointerNode head1 = DSCreationUtil.createSortedSinglyLinkedList(1, 3, 5, 7, 8, 9);
        ListSinglePointerNode.printList(head1);
        ListSinglePointerNode head2 = DSCreationUtil.createSortedSinglyLinkedList(2, 4, 6, 8, 10, 12);
        ListSinglePointerNode.printList(head2);
        ListSinglePointerNode mergedList = mergeSortedLL(head1, head2);
        ListSinglePointerNode.printList(mergedList);
    }

    private static ListSinglePointerNode mergeSortedLL(ListSinglePointerNode head1, ListSinglePointerNode head2) {

        ListSinglePointerNode result = null;
        if (head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        if(head1.getData() <= head2.getData()) {
            result = head1;
            result.setNext(mergeSortedLL(head1.getNext(), head2));
        } else {
            result = head2;
            result.setNext(mergeSortedLL(head1, head2.getNext()));
        }



        return result;
    }
}
