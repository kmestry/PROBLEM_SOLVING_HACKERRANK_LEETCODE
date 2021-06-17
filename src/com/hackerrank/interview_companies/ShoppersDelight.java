package com.hackerrank.interview_companies;

import java.util.List;

public class ShoppersDelight {
    public static long
    getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes,
                       List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {
        // Write your code here


        int count = 0;
        for (Integer i : priceOfJeans) {
            for (Integer j : priceOfShoes) {
                for (Integer k : priceOfSkirts) {
                    for (Integer l : priceOfTops) {
                        if (i + j + k + l <= budgeted) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

}
