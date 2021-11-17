package com.leetcode;

import java.util.*;

public class KDiffPairsInArrayTwoPointer {

    public int findPairs(int[] nums, int k) {
        //[3,1,4,1,5], k = 2

        if (nums.length < 2) return 0;
        // 1 1 3 4 5
        Interim interim = findPairsWhenKZero(nums, k);
        if (k == 0) {
            return interim.getVal();
        }

        int left = 0;
        int right = 1;
        List<Integer> list = interim.getNums();
        Collections.sort(list);
        int counter = 0;

        while (right < list.size()) {

            int diff = (list.get(right) - list.get(left));
            if (diff < k) {
                right++;
            } else if (diff > k) {
                left++;
            } else {
                counter++;
                left++;
                right++;
            }

        }

        return counter;
    }

    private Interim findPairsWhenKZero(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

        }
        int count = 0;
        List<Integer> newNums = new ArrayList<>();


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            newNums.add(entry.getKey());


            count += entry.getValue() / 2;
        }

        //special case where only one number is repeated in array. eg: [1,1,1,1]
        //as we want unique pair the result will be 1.
        if (map.size() == 1) {
            count = 1;
        }
        return new Interim(count, newNums);
    }

    class Interim {


        int val;
        List<Integer> nums;

        Interim() {

        }

        Interim(int val, List<Integer> nums) {
            this.val = val;
            this.nums = nums;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public List<Integer> getNums() {
            return nums;
        }

        public void setNums(List<Integer> nums) {
            this.nums = nums;
        }


    }
}
