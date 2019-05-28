package edu.ashish.dynamicprogramming;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * Time Complexity : O(n^2)
 */
public class CuttingRod {

    public static void main(String[] args) {

        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum profit after cutting rod is " + maxProfirFromRodCut(prices));
    }

    private static int maxProfirFromRodCut(int[] prices) {

        int[] res = new int[prices.length + 1];

        res[0] = 0;
        int max_val = Integer.MIN_VALUE;

        for (int i = 1; i <= prices.length; i++) {
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, prices[j] + res[i - j - 1]);
            }
            res[i] = max_val;
        }
        return res[prices.length];
    }
}
