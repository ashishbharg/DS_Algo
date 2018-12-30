package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;

/**
 * Program to find intersection or common point of two linked list where the linked list size can vary.
 */

public class FindIntersectionOfLinkedList {

    private static ListSinglePointerNode head1;

    private static  ListSinglePointerNode head2;

    public static void main(String[] args) {

        createTwoSinglyIntersectingLinkedList();
        ListSinglePointerNode.printList(head1);
        ListSinglePointerNode.printList(head2);
        ListSinglePointerNode node = findIntersectionNode(head1, head2);
        if(node == null) {
            System.out.println("There are no intersecting linked lists");
        } else {
            System.out.println("Linked Lists are intersecting at " + node.getData());
        }
    }

    private static ListSinglePointerNode findIntersectionNode(ListSinglePointerNode head1, ListSinglePointerNode head2) {

        int sizeOfList1 = 0, sizeOfList2 = 0;

        ListSinglePointerNode tempNode = head1;
        while (tempNode != null) {
            sizeOfList1++;
            tempNode = tempNode.getNext();
        }

        tempNode = head2;
        while (tempNode != null) {
            sizeOfList2++;
            tempNode = tempNode.getNext();
        }

        int diff = 0;
        if (sizeOfList1 > sizeOfList2) {
            diff = sizeOfList1 - sizeOfList2;
            while (diff != 0) {
                head1 = head1.getNext();
                diff--;
            }
        } else if (sizeOfList2 > sizeOfList1) {
            diff = sizeOfList2 - sizeOfList1;
            while (diff != 0) {
                head2 = head2.getNext();
                diff--;
            }
        }

        while(head1.getNext() != null) {
            if(head1 == head2) {
                return head1;
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        return null;
    }

    public static void createTwoSinglyIntersectingLinkedList() {
        head1 = new ListSinglePointerNode(5);
        ListSinglePointerNode node1 = new ListSinglePointerNode(8);
        head1.setNext(node1);
        ListSinglePointerNode node2 = new ListSinglePointerNode(3);
        node1.setNext(node2);
        ListSinglePointerNode node3 = new ListSinglePointerNode(7);
        node2.setNext(node3);
        ListSinglePointerNode node4 = new ListSinglePointerNode(1);
        node3.setNext(node4);
        ListSinglePointerNode node5 = new ListSinglePointerNode(9);
        node4.setNext(node5);

        head2 = new ListSinglePointerNode(15);
        ListSinglePointerNode node6 = new ListSinglePointerNode(13);
        head2.setNext(node6);
        ListSinglePointerNode node7 = new ListSinglePointerNode(5);
        node6.setNext(node7);
        node7.setNext(node4);
    }

}
