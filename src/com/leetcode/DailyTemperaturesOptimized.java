package com.leetcode;

import java.util.Stack;

public class DailyTemperaturesOptimized {


    public static void main(String[] args) {
        DailyTemperaturesOptimized dailyTemperaturesOptimized = new DailyTemperaturesOptimized();
        dailyTemperaturesOptimized.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Pair> sk = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!sk.isEmpty() && sk.peek().getKey() <= temperatures[i]) {
                sk.pop();
            }
            if (sk.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = sk.peek().getValue() - i;
            }
            sk.push(new Pair(temperatures[i], i));

        }

        return result;
    }
}

class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }
}
