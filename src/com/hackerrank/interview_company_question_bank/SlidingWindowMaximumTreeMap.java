package com.hackerrank.interview_company_question_bank;

import java.util.TreeMap;

public class SlidingWindowMaximumTreeMap {

    public static void main(String[] args) {
        SlidingWindowMaximumTreeMap slidingWindowMaximum = new SlidingWindowMaximumTreeMap();
        slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        //first window
        for (int i = 0; i < k; i++) {
            treeMap.merge(nums[i], 1, Integer::sum);
        }

        result[index] = treeMap.lastKey();
        index++;

        int pointer1 = 0;
        int pointer2 = k;
        while (pointer2 < nums.length) {
            int leftWindowValue = nums[pointer1];

            decrementLeftWindowElementValue(treeMap, leftWindowValue);

            int rightWindowValue = nums[pointer2];
            treeMap.merge(rightWindowValue, 1, Integer::sum);

            result[index] = treeMap.lastKey();

            pointer1++;
            pointer2++;
            index++;
        }
        return result;


    }

    private void decrementLeftWindowElementValue(TreeMap<Integer, Integer> treeMap, int leftWindowValue) {
        if (treeMap.containsKey(leftWindowValue)) {
            if (treeMap.get(leftWindowValue) > 1) {
                treeMap.put(leftWindowValue, treeMap.get(leftWindowValue) - 1);
            } else if (treeMap.get(leftWindowValue) <= 1) {
                treeMap.remove(leftWindowValue);
            }
        }
    }
}
