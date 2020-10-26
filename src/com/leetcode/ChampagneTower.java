package com.leetcode;

public class ChampagneTower {

    public static void main(String[] args) {
        new ChampagneTower().champagneTower(4, 2, 2);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[102][102];

        dp[0][0] = poured;


        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {

                double overFlow = (dp[i][j] - 1) / 2.0;

                if (overFlow > 0) {
                    dp[i + 1][j] += overFlow;
                    dp[i + 1][j + 1] += overFlow;
                }


            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }

}