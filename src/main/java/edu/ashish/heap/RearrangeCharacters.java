package edu.ashish.heap;

import static edu.ashish.util.PrintingUtil.print1DArray;

/**
 * Given a string with repeated characters, task is rearrange characters in a string so that no
 * two adjacent characters are same.
 *
 * Note : It may be assumed that the string has only lowercase English alphabets.
 *
 * Time Complexity: O(nlogn)
 */
public class RearrangeCharacters {

    private static int heapLength = 0;

    public static void main(String[] args) {
        String str = "aaaabbbcc";
        char[] characters = str.toCharArray();
        rearrangeCharacters(characters);
        print1DArray(characters);
    }

    private static void rearrangeCharacters(char[] characters) {

        buildHeap(characters);
    }

    private static void buildHeap(char[] characters) {

        int[] count = new int[26];
        int N = characters.length;

        for (int i = 0; i < N; i++) {
            count[characters[i] - 'a']++;
        }
        Key[] keys = new Key[N];
        for (char c = 'a'; c < 'z'; c++) {
            int val = c - 'a';
            if (count[val] > 0) {
                Key key = new Key(new Character(c), count[val]);
                insertInHeap(keys, key);
            }
        }

        for (int i = 0; i < N; i++) {
            Key key = maxHeapify(keys);
            characters[i] = key.ch;
            if (--key.frequency > 0) {
                insertInHeap(keys, key);
            }
        }


    }

    private static Key maxHeapify(Key[] keys) {

        Key key = keys[0];
        keys[0] = keys[--heapLength];
        sink(keys, 0);
        return key;
    }

    private static void sink(Key[] keys, int index) {

        int childIndex = 2 * index + 1;
        while (childIndex < heapLength) {

            if (keys[childIndex].compareTo(keys[childIndex + 1]) < 0) {
                childIndex++;
            }
            if (keys[index].compareTo(keys[childIndex]) < 0) {
                exch(keys, index, childIndex);
            } else {
                break;
            }
            index = childIndex;
            childIndex = 2 * index + 1;
        }
    }

    private static void insertInHeap(Key[] keys, Key key) {

        keys[heapLength] = key;
        swim(keys, heapLength);
        heapLength++;
    }

    private static void swim(Key[] keys, int index) {

        int parentIndex = index / 2;
        while (parentIndex >= 0) {

            if (keys[parentIndex].compareTo(keys[index]) < 0) {
                exch(keys, parentIndex, index);
            } else {
                break;
            }
            parentIndex = parentIndex / 2;
        }
    }

    private static void exch(Key[] keys, int parentIndex, int index) {
        Key temp = keys[parentIndex];
        keys[parentIndex] = keys[index];
        keys[index] = temp;
    }

    static class Key implements Comparable<Key> {

        private char ch;
        private int frequency;

        Key (char ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Key o1) {
            return this.frequency - o1.frequency;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "ch=" + ch +
                    ", frequency=" + frequency +
                    '}';
        }
    }
}
