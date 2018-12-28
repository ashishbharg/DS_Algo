package edu.ashish.circularlinkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

public class DeleteFirstNode {

    public static void main(String[] args) {

        ListSinglePointerNode head = DSCreationUtil.createSingularCircularList();
        ListSinglePointerNode.printList(head);
        head = deleteFirstNode(head);
        ListSinglePointerNode.printList(head);
    }

    private static ListSinglePointerNode deleteFirstNode(ListSinglePointerNode head) {
        ListSinglePointerNode currentNode = head;

        if (head == null) {
            System.out.println("List is empty");
            return null;
        } else if (head.getNext() == head) {
            head = null;
            return head;
        }

        while (currentNode.getNext() != head) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(head.getNext());
        head = currentNode.getNext();
        return head;
    }
}
