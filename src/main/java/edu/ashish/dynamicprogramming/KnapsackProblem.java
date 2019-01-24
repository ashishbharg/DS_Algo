package edu.ashish.dynamicprogramming;

import edu.ashish.util.PrintingUtil;

import java.util.Arrays;

/**
 * Program for knapsack problem. Weights are given with the prices. Need to find out the maximum price against the
 * weights that knapsack can carry. This algorithm is not 0-1 Knapsack problem which means that the weights can be
 * divided further rather than taking it as a whole. This algorithm is based on greedy method.
 *
 * Time Complexity os this solution is O(n)
 */
public class KnapsackProblem {

    private static int N = 0;

    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        int[] prices = new int[] {10, 5, 15, 7, 6, 18, 3};
        int[] weights = new int[] {2, 3, 5, 7, 1, 4, 1};

        System.out.println("Prices");
        PrintingUtil.print1DArray(prices);
        System.out.println("Weights");
        PrintingUtil.print1DArray(weights);
        int knapsackWeight = 15;
        double max = knapsack(weights, prices, knapsackWeight);
        System.out.println("Maximum profit can be made from knapsack is " + max);
    }

    private static double knapsack(int[] weights, int[] prices, int knapsackWeight) {

        if (knapsackWeight == 0 || weights.length == 0 || prices.length == 0) {
            return 0;
        }

        String[] pricePerWeight = new String[weights.length];

        for (int i = 0; i < pricePerWeight.length; i++) {
            pricePerWeight[i] = (double) prices[i] / weights[i] + SEPARATOR + i;
        }

        String[] heap = new String[pricePerWeight.length];

        for (int i = 0; i < pricePerWeight.length; i++) {
            insertInHeap(heap, pricePerWeight[i]);
            N++;
        }

        System.out.println(Arrays.toString(heap));

        int tempKnapSackWeight = knapsackWeight;
        double maxPrice = 0;
        while (tempKnapSackWeight != 0) {
            String maxHeap = maxHeap(heap);
            int index = fetchIndexFromString(maxHeap);
            if (tempKnapSackWeight - weights[index] > 0) {
                tempKnapSackWeight -= weights[index];
                maxPrice += prices[index];
            } else {
                maxPrice += fetchPriceFromString(pricePerWeight[index]) * tempKnapSackWeight;
                tempKnapSackWeight = 0;
            }
        }
        return maxPrice;
    }

    private static String maxHeap(String[] heap) {

        String maxHeap = heap[0];
        heap[0] = heap[--N];
        sink(heap, 0);
        heap[N] = "0" + SEPARATOR + "0";
        return maxHeap;
    }

    private static void sink(String[] heap, int index) {

        while(2 * index <= N) {
            int childIndex = 2 * index + 1;
            if (childIndex <= N && fetchPriceFromString(heap[childIndex]) < fetchPriceFromString(heap[childIndex + 1])) {
                childIndex++;
            } else if (fetchPriceFromString(heap[index]) > fetchPriceFromString(heap[childIndex])) {
                break;
            }
            String temp = heap[index];
            heap[index] = heap[childIndex];
            heap[childIndex] = temp;
            index = childIndex;
        }
    }

    private static int fetchIndexFromString(String s) {
        return Integer.parseInt(s.split(SEPARATOR)[1]);
    }

    private static void insertInHeap(String[] heap, String str) {

        heap[N] = str;
        swim(heap, N);
    }

    private static void swim(String[] heap, int index) {

        if (index == 0) {
            return;
        }
        int parentIndex = (index - 1) / 2;
        while (fetchPriceFromString(heap[index]) > fetchPriceFromString(heap[parentIndex])) {
            String temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private static double fetchPriceFromString(String s) {
        return Double.parseDouble(s.split(SEPARATOR)[0]);
    }
}
