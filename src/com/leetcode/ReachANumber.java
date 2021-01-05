package com.leetcode;

public class ReachANumber {

    public static void main(String[] args) {
        new ReachANumber().reachNumber(5);
    }

    public int reachNumber(int target) {
        target = Math.abs(target);

        int sum = 0;
        int step = 0;

        while (sum < target) {
            step++;
            sum += step;
        }

        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }

        return step;
    }
}
