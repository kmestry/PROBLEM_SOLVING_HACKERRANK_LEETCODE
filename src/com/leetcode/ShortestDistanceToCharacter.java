package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToCharacter {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                list.add(index);
            }
            index++;
        }

        // System.out.println(list);

        int index_ = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                result[index_] = 0;
            } else {
                int minDistance = Integer.MAX_VALUE;

                for (int i = 0; i < list.size(); i++) {
                    //  System.out.println(Math.abs(list.get(i) - index));
                    minDistance = Math.min(minDistance, Math.abs(list.get(i) - index_));
                }
                result[index_] = minDistance;
            }
            index_++;
        }

        return result;
    }
}
