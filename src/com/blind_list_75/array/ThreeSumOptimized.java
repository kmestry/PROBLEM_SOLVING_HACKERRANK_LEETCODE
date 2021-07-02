package com.blind_list_75.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumOptimized {

    //[-2,0,0,2,2] imp test case to understand while loops
    public static void main(String[] args) {
        ThreeSumOptimized threeSum = new ThreeSumOptimized();
        List<List<Integer>> result = threeSum.threeSum(new int[]{-2, 0, 0, 2, 2});
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        // -2,0,0,2,2]
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int num1 = nums[i];

            int lo = i + 1;
            int high = nums.length - 1;

            while (lo < high) {
                int sum = num1 + nums[lo] + nums[high];
                if (sum == 0) {
                    List<Integer> inList = Arrays.asList(num1, nums[lo], nums[high]);
                    list.add(inList);

                    while (lo < high && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < high && nums[high] == nums[high - 1]) high--;

                    lo++;
                    high--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    high--;
                }
            }


        }
        return list;
    }
}
