package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongWithDurationDivisibleBy60 {

    public static void main(String[] args) {
        // new PairsOfSongWithDurationDivisibleBy60().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40, 210});
        new PairsOfSongWithDurationDivisibleBy60().numPairsDivisibleBy60(new int[]{60, 60, 60});
    }

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap();

        for (int t : time) {
            if (t % 60 == 0) {
                count += map.getOrDefault(0, 0);
            } else {
                count += map.getOrDefault(60 - t % 60, 0);
            }

            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }

        return count;
    }
}
