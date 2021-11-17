package com.leetcode;

import java.util.*;

public class PartitionLabels {

    public static void main(String[] args) {
        List<Integer> list = new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
        System.out.println("list = " + list);
    }

    public List<Integer> partitionLabels(String inputString) {

        Map<Character, Integer> map = new HashMap<>();    // map to maintain last index position of a character

        for (int i = 0; i < inputString.length(); i++) {

            char c = inputString.charAt(i);

            map.put(c, i);
        }

        List<Integer> result = new ArrayList<>();
        Set<Character> seenSet = new HashSet<>();
        int left = 0;
        int right = map.get(inputString.charAt(left));
        int interval = right;
        seenSet.add(inputString.charAt(left));
        while (right < inputString.length()) {


            if (left == interval) {
                insertInResultList(result, interval);

                if (interval < inputString.length()) {
                    left = interval + 1;
                    if (left >= inputString.length()) break;
                    right = map.get(inputString.charAt(left));
                    interval = right;
                }
            } else {
                char ch = inputString.charAt(left);
                if (!seenSet.contains(ch)) {
                    int rangeOfChar = map.get(ch);
                    if (rangeOfChar > interval) {
                        interval = rangeOfChar;
                    }
                    seenSet.add(ch);
                }

                //interval = getInterval(inputString, map, left, interval, ch);
                left++;
            }
        }


        return result;

    }

    private int getInterval(String s, Map<Character, Integer> map, int left, int interval, char ch) {
        if (ch != s.charAt(left)) {
            int i = map.get(ch);
            if (i > interval) {
                interval = i;
            }
        }
        return interval;
    }

    private void insertInResultList(List<Integer> result, int interval) {
        if (!result.isEmpty()) {
            int currSize = 0;
            for (Integer k : result) {
                currSize += k;
            }

            result.add(interval + 1 - currSize);
        } else {
            result.add(interval + 1);
        }
    }
}
