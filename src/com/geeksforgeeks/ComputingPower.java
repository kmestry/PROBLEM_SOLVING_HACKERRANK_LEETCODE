package com.geeksforgeeks;

public class ComputingPower {

    public static void main(String[] args) {

        int result = new ComputingPower().computePower(3, 4);
        System.out.println("result = " + result);
    }

    private int computePower(int num, int power) {
        int result = 1;
        while (power > 0) {
            result *= num;
            power--;
        }
        return result;
    }
}
