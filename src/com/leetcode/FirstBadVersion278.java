package com.leetcode;

public class FirstBadVersion278 {

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        if (n == 1) {
            return 1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            boolean resultMid = isBadVersion(mid);
            if (!resultMid) {
                left = mid + 1;
            } else {
                right = mid;
            }


        }

        return left;
    }

    public static void main(String[] args) {

    }

    public static boolean isBadVersion(int number) {
        return true;
    }
}
