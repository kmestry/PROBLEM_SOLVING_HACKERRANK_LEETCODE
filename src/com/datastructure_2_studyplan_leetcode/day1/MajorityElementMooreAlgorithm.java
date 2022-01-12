package com.datastructure_2_studyplan_leetcode.day1;

public class MajorityElementMooreAlgorithm {

    public int majorityElement(int[] nums) {

        int result = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                result = num;
                count++;
            } else {
                if (num == result) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return result;
    }
}
