package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        if (nums.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;


        while (j < nums.length - 1) {
            if (nums[j + 1] == nums[j] + 1) {
                j++;
            } else {
                StringBuilder range = new StringBuilder();
                String rangeString;
                if (i != j)
                    rangeString = range.append(nums[i]).append("->").append(nums[j]).toString();
                else {
                    rangeString = range.append(nums[i]).toString();
                }
                j++;
                i = j;
                result.add(rangeString);
            }

        }
        StringBuilder range = new StringBuilder();
        String rangeString;
        if (i != j)
            rangeString = range.append(nums[i]).append("->").append(nums[j]).toString();
        else {
            rangeString = range.append(nums[i]).toString();
        }
        result.add(rangeString);

        return result;
    }
}
