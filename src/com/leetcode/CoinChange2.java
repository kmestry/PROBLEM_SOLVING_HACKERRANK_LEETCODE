package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CoinChange2 {

    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        new CoinChange2().change(3, new int[]{1, 2});
    }

    public int change(int amount, int[] coins) {

        return helper(amount, coins, 0);
    }


    private int helper(int amount, int[] coins, int index) {


        if (amount == 0) return 1;

        String key = new StringBuilder().append(amount).append("kun").append(index).toString();
        if (map.containsKey(key))
            return map.get(key);

        if (index >= coins.length || amount < 0) return 0;
        int coinSelected = 0;
        for (int i = index; i < coins.length; i++) {
            if (coins[i] <= amount) {
                coinSelected += helper(amount - coins[i], coins, i);
            }
        }

        map.put(key, coinSelected);
        return coinSelected;


    }
}
