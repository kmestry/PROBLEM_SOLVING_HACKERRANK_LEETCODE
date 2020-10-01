package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfRecentCalls {


    List<Integer> list;

    public NumberOfRecentCalls() {
        this.list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int lowRange = t - 3000;

        int counter = 0;
        for (int element : list) {
            if (element >= lowRange && element <= t) {
                counter++;
            }
        }

        return counter;
    }
}
