package com.leetcode;

public class TeemoAttacking {

    public static void main(String[] args) {

        new TeemoAttacking().findPoisonedDuration(new int[]{1, 4}, 2);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if (timeSeries.length == 0) return 0;

        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }


        return total + duration;
    }
}
