package com.leetcode;

public class KthFactorOfN {

    public static void main(String[] args) {
        new KthFactorOfN().kthFactor(7, 2);
    }

    public int kthFactor(int n, int k) {

        int count = 0;
        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                count++;
            }

            if (count == k) {
                return i;
            }
        }

        return -1;
    }

}
