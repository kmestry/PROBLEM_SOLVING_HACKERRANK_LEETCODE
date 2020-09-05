package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }

        }


        List<Integer> resultList = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            resultList.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            resultList.add(candidate2);
        }

        return resultList;

    }
}
