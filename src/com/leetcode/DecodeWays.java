package com.leetcode;

public class DecodeWays {

    public static void main(String[] args) {
       /*int result =  new DecodeWays().numDecodings("2208");
        System.out.println("result = " + result);*/

        int result = new DecodeWays().numDecodings("230");
        System.out.println("result = " + result);
    }

    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) - '0' == 0) {
            return 0;
        }

        int[] waysToDecode = new int[s.length() + 1];
        waysToDecode[0] = 1;
        waysToDecode[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';

            // can't make progress, return 0
            //|| curr == 0 && prev * 10 + curr > 26
            if (prev == 0 && curr == 0) {
                return 0;
            }
            // can't use the previous value, so can only get to this state from the previous
            else if (prev == 0 || (prev * 10 + curr) > 26) {
                waysToDecode[i + 1] = waysToDecode[i];
            }
            // can't use current state, can only get to this state from i - 1 state
            else if (curr == 0) {
                waysToDecode[i + 1] = waysToDecode[i - 1];
            }
            // can get to this state from the previous two states
            else {
                waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1];
            }
        }

        return waysToDecode[waysToDecode.length - 1];
    }
}
