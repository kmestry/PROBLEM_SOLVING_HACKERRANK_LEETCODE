package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StoneGame {

    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        stoneGame.stoneGame(new int[]{3, 7, 2, 3});
    }
/*
    What does it mean for Alex to win? Alex will win if score(Alex) >= score(Lee), but this also means score(Alex) - score(Lee) >= 0,
    so here you have a common parameter which is a score variable. The score parameter really means score = score(Alex) - score(Lee).

    Now, if each player is supposed to play optimally, how do you decide this with one variable?

    Well since Alex is playing optimally, he wants to maximize the score variable because remember,
    Alex only wins if score = score(Alex) - score(Lee) >= 0 Alex should add to the score because he wants to maximize it.
    Since Lee is also playing optimally, he wants to minimize the score variable,
    since if the score variable becomes negative, Lee has more individual score than Alex.
    But since we have only one variable, Lee should damage the score (or in other words, subtract from the score).

    */

    public boolean stoneGame(int[] piles) {


        int result = helper(piles, 0, piles.length - 1, true);
        return result >= 0;
    }

    private int helper(int[] piles, int start, int end, boolean isAlexTurn) {

        if (start > end) {
            return 0;
        }

        String key = isAlexTurn + "_" + start + "_" + end;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (isAlexTurn) {

            int pickFirst = helper(piles, start + 1, end, false) + piles[start];
            int pickLast = helper(piles, start, end - 1, false) + piles[end];


            int alexMax = Math.max(pickFirst, pickLast);
            map.put(key, alexMax);
            return alexMax;
        } else {

            int pickFirst = helper(piles, start + 1, end, true) - piles[start];
            int pickLast = helper(piles, start, end - 1, true) - piles[end];

            int leeMin = Math.min(pickFirst, pickLast);
            map.put(key, leeMin);
            return leeMin;

        }

    }
}
