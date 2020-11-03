package com.leetcode;

public class ConsecutiveCharacters {

    public static void main(String[] args) {
        new ConsecutiveCharacters().maxPower("leetcode");
    }

    public int maxPower(String s) {
        //leetcode

        if (s.length() == 1) return 1;
        int left = 0;
        int right = 0;
        int maxPower = 0;
        while (right < s.length()) {
            if (s.charAt(right) == s.charAt(left)) {
                right++;
            } else {
                maxPower = Math.max(maxPower, right - left);
                left++;
            }
        }
        maxPower = Math.max(maxPower, right - left); //this case is required when we have string like "tt".Else part
        //is not executed in above while loop
        return maxPower;
    }
}
