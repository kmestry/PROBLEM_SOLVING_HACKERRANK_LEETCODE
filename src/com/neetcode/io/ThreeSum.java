package com.neetcode.io;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        new ThreeSum().threeSumOptimized(new int[]{-2, 0, 0, 2, 2
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[l] + nums[r] + currNum;
                System.out.println(sum);
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(currNum, nums[l], nums[r]);
                    res.add(list);
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }

        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];

                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[l], nums[r], nums[i]);
                    res.add(list);

                    while (l < nums.length - 1 && l < r && nums[l] == nums[l + 1]) {

                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {

                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) r--;
                else l++;


            }


        }
        return res;
    }
}
