package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TLE brute force.
public class NextPermutationJanChallenge {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        new NextPermutationJanChallenge().nextPermutation(new int[]{1, 1, 5});

    }

    public void nextPermutation(int[] nums) {

        List<Integer> origList = new ArrayList<>();
        for (int i : nums) {
            origList.add(i);
        }
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), new boolean[nums.length]);


        int index = -1;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).equals(origList)) {
                if (i == result.size() - 1) {
                    index = 0;
                } else {
                    index = i + 1;
                }
            }
        }

        List<Integer> newList = result.get(index);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newList.get(i);
        }

        System.out.println("nums = " + nums);

        System.out.println("===" + newList);
    }

    public void helper(int[] nums, int index, List<Integer> list, boolean[] visited) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, i, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }

    }
}
