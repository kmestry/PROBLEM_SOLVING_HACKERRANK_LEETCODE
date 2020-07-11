package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    //[1,2,3,4,5,6]

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int n : nums) {

            int size = result.size();
            for (int i = 0; i < size; i++) {

                List<Integer> innerList = new ArrayList<>(result.get(i));
                innerList.add(n);
                result.add(innerList);

            }


        }
        return result;

    }
}
