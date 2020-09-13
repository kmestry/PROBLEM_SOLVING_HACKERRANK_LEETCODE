package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {

    public static void main(String[] args) {
        new BeautifulArrangement().countArrangement(4);
    }

    public int countArrangement(int N) {

        int result = helper(N, new ArrayList<>());
        System.out.println("result = " + result);
        return result;
    }

    private int helper(int N, List<Integer> list) {

        if (list.size() == N) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {

            if (list.contains(i)) continue;
            int index = list.size() + 1;

            if (i % index == 0 || index % i == 0) {

                list.add(i);
                count += helper(N, list);
                list.remove(list.size() - 1);

            }

        }

        return count;


    }
}
