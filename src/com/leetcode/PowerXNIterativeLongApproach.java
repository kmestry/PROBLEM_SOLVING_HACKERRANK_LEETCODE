package com.leetcode;

public class PowerXNIterativeLongApproach {

    public static void main(String[] args) {
        new PowerXNIterativeLongApproach().myPow(2, 10);
    }

    public double myPow(double x, int n) {

        double answer = 1.0;
        long nn = n;

        if (nn < 0) {
            nn = -1 * nn;
        }

        while (nn > 0) {

            if (nn % 2 == 0) {

                x = x * x;
                nn = nn / 2;

            } else {
                answer = answer * x;
                nn = nn - 1;
            }

        }

        if (n < 0) {
            answer = 1.0 / answer;
        }

        return answer;
    }
}
