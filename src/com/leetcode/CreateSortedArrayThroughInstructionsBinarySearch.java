package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CreateSortedArrayThroughInstructionsBinarySearch {

    int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        new CreateSortedArrayThroughInstructionsBinarySearch().createSortedArray(new int[]{1, 2, 3, 6, 5, 4});
    }

    public int createSortedArray(int[] instructions) {
        List<Integer> nums = new ArrayList<>();
        long sum = 0;

        for (int instr : instructions) {
            int min = binSearchMin(nums, instr);
            int max = nums.size() - binSearchMax(nums, instr);
            sum += Math.min(min, max);
            nums.add(min, instr);
        }

        return (int) (sum % MOD);
    }

    public int binSearchMax(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;

        if (r < l) {
            return 0;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums.get(r) <= target ? r + 1 : r;
    }

    public int binSearchMin(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;

        if (r < l) {
            return 0;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums.get(r) < target ? r + 1 : r;
    }
}
