package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber3Optimized {

    public static void main(String[] args) {
        int[] result = singleNumberBitMask(new int[]{1, 2, 1, 3, 2, 5});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    //using hashset
    public static int[] singleNumber(int[] nums) {

        Set<Integer> integerSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (integerSet.contains(nums[i])) {
                integerSet.remove(nums[i]);
            } else {
                integerSet.add(nums[i]);
            }
        }

        return integerSet.stream().mapToInt(value -> value).toArray();

    }

    public static int[] singleNumberBitMask(int[] nums) {

        int bitMask = 0;
        for (int i : nums) {
            bitMask = bitMask ^ i;
        }
        int diffBitMask = bitMask & (-bitMask);
        int x = 0;
        for (int j : nums) {
            if ((diffBitMask & j) > 0) {
                x = x ^ j;
            }
        }

        return new int[]{x, bitMask ^ x};
    }
}
