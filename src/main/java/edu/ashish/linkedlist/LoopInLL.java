package edu.ashish.linkedlist;

import edu.ashish.model.ListSinglePointerNode;
import edu.ashish.util.DSCreationUtil;

public class LoopInLL {

    private static boolean isLoopExist = false;

    private static ListSinglePointerNode startingNodeOfLoop = null;

    private static int lengthOfLoop = 0;

    public static void main(String[] args) {
        ListSinglePointerNode head = DSCreationUtil.createLoopInLinkedList();
        doOpsOnLinkedList(head);
        System.out.println("Loop exists? : " + isLoopExist);
        System.out.println("Starting node of Loop is: " + startingNodeOfLoop.getData());
        System.out.println("Length of the loop is: " + lengthOfLoop);

    }

    private static void doOpsOnLinkedList(ListSinglePointerNode head) {

        ListSinglePointerNode slowPtr = head;
        ListSinglePointerNode fastPtr = head;
        while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
               slowPtr = slowPtr.getNext();
               fastPtr = fastPtr.getNext().getNext();
               if(slowPtr == fastPtr) {
                    isLoopExist = true;
                    break;
               }
        }
        if(isLoopExist) {
            ListSinglePointerNode tempNode = head;
            while(tempNode != slowPtr) {
                tempNode = tempNode.getNext();
                slowPtr = slowPtr.getNext();
            }
            startingNodeOfLoop = tempNode;
            slowPtr = fastPtr.getNext();
            lengthOfLoop++;
            while (slowPtr != fastPtr) {
                lengthOfLoop++;
                slowPtr = slowPtr.getNext();

            }
        }
    }


}
