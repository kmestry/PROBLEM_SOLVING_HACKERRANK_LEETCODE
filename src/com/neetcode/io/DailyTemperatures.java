package com.neetcode.io;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperaturesBrute(int[] temperatures) {

        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int currDay = 0; currDay < temperatures.length; currDay++) {

            while (!stk.isEmpty() && temperatures[currDay] > temperatures[stk.peek()]) {
                int prevDay = stk.pop();
                res[prevDay] = currDay - prevDay;
            }

            stk.push(currDay);
        }

        return res;
    }
}
