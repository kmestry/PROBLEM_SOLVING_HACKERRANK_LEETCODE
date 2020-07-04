package com.leetcode;

public class UglyNumberDynamicProgramming264 {

    public static void main(String[] args) {
        int result = nthUglyNumber(10);
        System.out.println(result);
    }

    public static int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        //o=pointers for 2,3,5 namely p2,p3 and p5.
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {
            int minValue = Math.min(2 * result[p2], Math.min(3 * result[p3], 5 * result[p5]));
            result[i] = minValue;

            if (minValue == 2 * result[p2]) {
                p2++;
            }
            if (minValue == 3 * result[p3]) {
                p3++;
            }
            if (minValue == 5 * result[p5]) {
                p5++;
            }

        }

        return result[n - 1];
    }
}
