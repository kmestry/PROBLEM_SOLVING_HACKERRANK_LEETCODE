package com.leetcode;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        int index = 0;

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[index] = j - i;
                    break;
                }
            }
            if (result[index] == 0)
                result[index] = 0;
            index++;
        }

        return result;
    }
}
