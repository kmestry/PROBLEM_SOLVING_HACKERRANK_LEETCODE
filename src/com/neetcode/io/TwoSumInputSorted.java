package com.neetcode.io;

public class TwoSumInputSorted {

    public int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];

        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            if (target == numbers[l] + numbers[r]) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }

        return res;
    }
}
