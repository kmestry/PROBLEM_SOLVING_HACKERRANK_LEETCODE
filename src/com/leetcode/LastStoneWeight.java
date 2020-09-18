package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LastStoneWeight {

    //[2,7,4,1,8,1]

    List<Integer> stonesList = new ArrayList<>();

    public static void main(String[] args) {

        int result = new LastStoneWeight().lastStoneWeight(new int[]{2, 2});
        System.out.println("result = " + result);
    }

    public int lastStoneWeight(int[] stones) {

        for (int i = 0; i < stones.length; i++) {
            stonesList.add(stones[i]);
        }
        return helper(stonesList);

    }

    private int helper(List<Integer> stonesList) {


        Collections.sort(stonesList);


        if (stonesList.size() > 1) {

            int x = stonesList.get(stonesList.size() - 2);
            int y = stonesList.get(stonesList.size() - 1);

            if (x <= y) {
                if (x == y) {
                    stonesList.remove(stonesList.size() - 1);
                    stonesList.remove(stonesList.size() - 1);
                } else {
                    int diff = y - x;
                    stonesList.remove(stonesList.size() - 1);
                    stonesList.remove(stonesList.size() - 1);
                    stonesList.add(diff);
                }
            }

            helper(stonesList);


        }

        if (stonesList.size() == 1) {
            return stonesList.get(0);
        }

        return 0;

    }
}
