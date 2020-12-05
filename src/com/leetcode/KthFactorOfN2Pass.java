package com.leetcode;

public class KthFactorOfN2Pass {

    public static void main(String[] args) {

        new KthFactorOfN2Pass().kthFactor(12, 4);
    }

    public int kthFactor(int n, int k) {

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }

        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return n / i;
                }
            }
        }

        return -1;
    }
}
