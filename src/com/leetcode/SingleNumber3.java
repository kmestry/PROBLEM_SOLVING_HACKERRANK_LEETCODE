package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber3 {

    public static void main(String[] args) {
        int[] result = singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] singleNumber(int[] nums) {

        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numberMap.containsKey(nums[i])) {

                numberMap.put(nums[i], numberMap.get(nums[i]) + 1);

            } else {
                numberMap.put(nums[i], 1);
            }
        }

        // System.out.println("numberMap = " + numberMap);


        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> m : numberMap.entrySet()) {
            if (index > 1) break;
            if (m.getValue() == 1) {
                result[index] = m.getKey();
                index++;
            }
        }
        return result;
    }
}
