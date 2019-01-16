package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

/**
 * Program to check if linked list is palindrome or not. Reversing the half linked list as checking the elements
 * would have become very easy problem.
 */
public class LinkedListPalindrome {

    public static void main(String[] args) {

        ListSinglePointerNode head = DSCreationUtil.createSinglyLinkedList();
        ListSinglePointerNode.printList(head);
        head = reverseHalfLinkedList(head);
        ListSinglePointerNode.printList(head);
        boolean isListPalindrome = isListPalindrome(head);
        System.out.println("isPalindrome: " + isListPalindrome);
        head = reverseHalfLinkedList(head);
        ListSinglePointerNode.printList(head);
    }

    private static boolean isListPalindrome(ListSinglePointerNode head) {

        ListSinglePointerNode slowPtr = head;
        ListSinglePointerNode fastPtr = head;

        while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }

        if (fastPtr.getNext() == null) {
            fastPtr = slowPtr.getNext();
        }
        slowPtr = head;

        while (fastPtr != null) {
           if(fastPtr.getData() != slowPtr.getData()) {
               return false;
           }
           slowPtr = slowPtr.getNext();
           fastPtr = fastPtr.getNext();
        }
        return true;
    }

    private static ListSinglePointerNode reverseHalfLinkedList(ListSinglePointerNode head) {

        ListSinglePointerNode slowPtr = head;
        ListSinglePointerNode fastPtr = head;

        while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }

        fastPtr = slowPtr.getNext();
        fastPtr = reverseLinkedList(fastPtr);
        slowPtr.setNext(fastPtr);
        return head;
    }

    private static ListSinglePointerNode reverseLinkedList(ListSinglePointerNode head) {

        ListSinglePointerNode tempNode;
        ListSinglePointerNode newNode = null;

        while(head != null) {
            tempNode = head;
            head = head.getNext();
            tempNode.setNext(null);
            if (newNode == null) {
                newNode = tempNode;
            } else {
                tempNode.setNext(newNode);
                newNode = tempNode;
            }
        }
        return newNode;
    }
}
