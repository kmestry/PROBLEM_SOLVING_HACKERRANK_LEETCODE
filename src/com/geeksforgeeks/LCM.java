package com.geeksforgeeks;

public class LCM {

    //naive solution
    public static void main(String[] args) {

        int result = new LCM().findLCM(3, 7);
        System.out.println("result = " + result);
    }

    private int findLCM(int a, int b) {

        int checkNum = Math.max(a, b);
        int lcm = -10;
        while (true) {
            if (checkNum % a == 0 && checkNum % b == 0) {
                lcm = checkNum;
                break;
            } else
                checkNum++;
        }

        return lcm;
    }
}
