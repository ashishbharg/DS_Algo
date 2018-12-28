package edu.ashish.model;

public class ListSinglePointerNode {

    private int data;

    private ListSinglePointerNode next;

    public ListSinglePointerNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListSinglePointerNode getNext() {
        return next;
    }

    public void setNext(ListSinglePointerNode next) {
        this.next = next;
    }

    public static void printList(ListSinglePointerNode head) {
        ListSinglePointerNode currentNode = head;
        System.out.println("Printing circular linked list");
        while(currentNode != null) {
            System.out.print(currentNode.getData());
            if(head != currentNode.getNext() && null != currentNode.getNext()) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.getNext();
            if(currentNode == head) {
                break;
            }
        }
        System.out.println();
    }

}
