package edu.ashish.heap;

/**
 * Program to find height of heap. Mathematical formula for finding the height of heap is ceil(log2(n + 1)) - 1.
 */
public class HeightOfHeap {

    public static void main(String[] args) {

        int heapSize = 10;

        // In Java, Math.log() uses base e. In order to get log(n) for base 2, need to perform log(n) / log(2).
        int height = (int) Math.ceil(Math.log(heapSize + 1) / Math.log(2)) - 1;

        System.out.println("Height of heap with heap size of " + heapSize + " is: " + height);
    }
}
