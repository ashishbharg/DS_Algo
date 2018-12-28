package edu.ashish.circularlinkedlist;

import edu.ashish.util.DSCreationUtil;
import edu.ashish.model.ListSinglePointerNode;

public class DeleteLastNode {

    public static void main(String[] args) {

        ListSinglePointerNode head = DSCreationUtil.createSingularCircularList();

        ListSinglePointerNode.printList(head);

        head = deleteLastNode(head);

        ListSinglePointerNode.printList(head);
    }



    private static ListSinglePointerNode deleteLastNode(ListSinglePointerNode head) {

        ListSinglePointerNode currentNode = head;
        ListSinglePointerNode prevNode = head;

        if (head == null) {
            System.out.println("List is empty");
            return null;
        } else if (head.getNext() == head) {
            head = null;
            return head;
        }

        while (head != currentNode.getNext()) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        prevNode.setNext(head);
        currentNode = null;
        return head;
    }
}
