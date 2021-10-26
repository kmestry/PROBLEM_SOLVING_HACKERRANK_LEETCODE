package com.leetcode_restart;

public class FirstBadVersion {

    public int firstBadVersion(int n) {

        int l = 1;
        int r = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            boolean flag = isBadVersion(mid);

            if (flag) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;

    }

    //dummy method
    private boolean isBadVersion(int mid) {
        return false;
    }
}
