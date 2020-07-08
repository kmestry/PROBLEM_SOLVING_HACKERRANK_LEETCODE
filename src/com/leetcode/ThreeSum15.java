package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum15 {

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("result = " + result);
    }

    // [-1, 0, 1, 2, -1, -4],
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        int windowSize = 3;
        int firstInt = 0;
        int firstIntIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        Collections.sort(innerList);

                        if (!resultList.contains(innerList))

                            resultList.add(innerList);
                       /* if (nums[i] != 0) {
                            firstInt = nums[i];
                            firstIntIndex = i;

                        } else if (nums[j] != 0) {
                            firstInt = nums[j];
                            firstIntIndex = j;

                        } else {
                            firstInt = nums[k];
                            firstIntIndex = k;

                        }*/

                    }
                }
            }
        }


      /*  for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (firstInt + nums[i] + nums[j] == 0) {
                    TreeSet<Integer> innerList = new TreeSet<>();
                    innerList.add(firstInt);
                    innerList.add(nums[i]);
                    innerList.add(nums[j]);
                    resultList.add(innerList);
                }

            }

        }*/


        return resultList;


    }
}
