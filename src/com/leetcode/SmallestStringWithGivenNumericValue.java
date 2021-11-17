package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//backtracking TLE.
public class SmallestStringWithGivenNumericValue {


    StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        String result = new SmallestStringWithGivenNumericValue().getSmallestString(5, 73);
        System.out.println("result = " + result);
    }

    public String getSmallestString(int n, int k) {

        helper(n, k, new ArrayList<>(), 0);
        return result.toString();
    }

    private void helper(int n, int k, List<Character> list, int sum) {

        if (list.size() > n) {
            return;
        }

        if (list.size() == n) {
            if (sum == k) {
                for (Character c : list) {
                    result.append(c);

                }
            }
            return;
        }

        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            list.add(ch);
            helper(n, k, list, sum + i + 1);
            list.remove(list.size() - 1);
            if (result.length() > 0) {
                return;
            }
        }
    }
}
