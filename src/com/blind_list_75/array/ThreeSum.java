package com.blind_list_75.array;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = num1 + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list_inner = new ArrayList<>();
                    list_inner.add(num1);
                    list_inner.add(nums[j]);
                    list_inner.add(nums[k]);

                    list.add(list_inner);
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(list);
    }
}
