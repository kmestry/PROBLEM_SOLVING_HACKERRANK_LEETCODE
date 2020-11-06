package com.leetcode;

public class CoinChange {

    public static void main(String[] args) {
        //new CoinChange().coinChange(new int[]{1, 2, 5}, 11);
        new CoinChange().coinChange(new int[]{2}, 3);
    }

    public int coinChange(int[] coins, int amount) {

        helper(coins, amount, 0, 0);

        System.out.println("min = " + min);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    int min = Integer.MAX_VALUE;

    private void helper(int[] coins, int amount, int index, int countCoins) {

        if (amount == 0) {
            min = Math.min(min, countCoins);
            return;
        }
        if (amount < 0 || index >= coins.length) {
            return;
        }

        for (int i = index; i < coins.length; i++) {

            helper(coins, amount - coins[index], index, countCoins + 1);
            helper(coins, amount, index + 1, countCoins);
        }


    }
}
