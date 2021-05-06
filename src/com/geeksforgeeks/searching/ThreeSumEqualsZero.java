package com.geeksforgeeks.searching;

import java.util.*;

public class ThreeSumEqualsZero {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            List<Pair> pair = isValidPair(nums, i + 1, nums.length - 1, -nums[i]);
            for (Pair p : pair) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(p.x);
                list.add(p.y);

                result.add(list);
            }
        }

        return new ArrayList<>(result);

    }


    private List<Pair> isValidPair(int[] nums, int low, int high, int target) {

        List<Pair> result = new ArrayList<>();
        while (low < high) {
            int sum = nums[low] + nums[high];

            if (sum == target) {
                Pair pair = new Pair(nums[low], nums[high]);
                result.add(pair);
                low++;
                high--;

            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }

        return result;

    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
