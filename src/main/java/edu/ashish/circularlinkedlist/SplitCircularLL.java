package edu.ashish.circularlinkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to split circular linked list into two equal parts. If the number of nodes in the list are odd then
 * make first list one node extra than second list.
 */
public class SplitCircularLL {

    public static void main(String[] args) {
        ListSinglePointerNode head = DSCreationUtil.createSingularCircularList();
        ListSinglePointerNode.printList(head);
        ListSinglePointerNode[] heads = splitCirculatList(head);
        for(ListSinglePointerNode list : heads) {
            ListSinglePointerNode.printList(list);
        }
    }

    private static ListSinglePointerNode[] splitCirculatList(ListSinglePointerNode head) {

        ListSinglePointerNode head2 = null;
        ListSinglePointerNode slowPtr = head;
        ListSinglePointerNode fastPtr = head;

        if (head == null  || head.getNext() == null) {
            return new ListSinglePointerNode[] {head};
        }

        while (fastPtr.getNext() != head && fastPtr.getNext().getNext() != head) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }

        if(fastPtr.getNext().getNext() == head) {
            fastPtr = fastPtr.getNext();
        }

        if(head.getNext() != head) {
            head2 = slowPtr.getNext();
        }

        fastPtr.setNext(head2);
        slowPtr.setNext(head);
        return new ListSinglePointerNode[] {head, head2};
    }
}
