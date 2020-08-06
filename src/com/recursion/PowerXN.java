package com.recursion;

public class PowerXN {

    int result = 1;

    public static void main(String[] args) {

        int result = new PowerXN().calculatePower(5, 8);
        System.out.println("result = " + result);
    }

    public int calculatePower(int x, int n) {

        if (n == 0)
            return 1;

        result = result * x;
        calculatePower(x, n - 1);

        return result;
    }
}

