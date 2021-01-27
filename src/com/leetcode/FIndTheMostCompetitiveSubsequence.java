package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FIndTheMostCompetitiveSubsequence {

    List<List<Integer>> set = new ArrayList<>(1);

//    public static void main(String[] args) {
//        new FIndTheMostCompetitiveSubsequence().mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3);
//
//        //[71,18,52,29,55,73,24,42,66,8,80,2]
//        //3
//    }

    public int[] mostCompetitive(int[] nums, int k) {

        helper(new ArrayList<>(), k, nums, 0);

        // set.stream().flatMap(integers ->)

        System.out.println(set);
        List<Integer> listResult = set.get(0);
        return listResult.stream().mapToInt(value -> value).toArray();

    }

    private void helper(List<Integer> list, int k, int[] nums, int index) {

        if (list.size() == k) {
            if (set.isEmpty())
                set.add(new ArrayList(list));
            else {
                List<Integer> initialList = set.get(0);
                boolean isReplaceInitialList = false;
                for (int i = 0; i < initialList.size(); i++) {
                    if (!list.get(i).equals(initialList.get(i))) {
                        if (list.get(i) < initialList.get(i)) {
                            isReplaceInitialList = true;
                            break;
                        }
                    }
                }
                if (isReplaceInitialList) {
                    set.remove(0);
                    set.add(new ArrayList(list));
                }
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {

            list.add(nums[i]);
            helper(list, k, nums, i + 1);
            list.remove(list.size() - 1);

        }


    }


}
