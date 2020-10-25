package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StoneGame4 {

    Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        StoneGame4 stoneGame4 = new StoneGame4();
        stoneGame4.winnerSquareGame(7);
    }

    public boolean winnerSquareGame(int n) {
        if (n == 0) return false;
        // if (map.containsKey(n)) return map.get(n);
        boolean res = false;
        for (int i = 1; i * i <= n; i++) {
            if (!winnerSquareGame(n - i * i)) {
                res = true;
                break;
            }
        }
        // map.put(n, res);
        return res;
    }
}
