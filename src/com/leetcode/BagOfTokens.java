package com.leetcode;

import java.util.Arrays;

public class BagOfTokens {

    public static void main(String[] args) {
        int maxScore = new BagOfTokens().bagOfTokensScore(new int[]{100, 200, 300, 400}, 200);

        System.out.println("maxScore = " + maxScore);
    }

    public int bagOfTokensScore(int[] tokens, int P) {

        Arrays.sort(tokens);
        return helper(tokens, P, 0, tokens.length - 1, 0);

    }

    private int helper(int[] tokens, int power, int start, int end, int score) {

        //2 pointer greedy approach.
        if (start > end) {
            return score;
        }

        int max = score;

        if (power >= tokens[start]) {
            max = Math.max(max, helper(tokens, power - tokens[start], start + 1, end, score + 1)); //play face up
        } else if (score > 0) {
            max = Math.max(max, helper(tokens, power + tokens[end], start, end - 1, score - 1)); //play face down

        }

        return max;
    }
}
