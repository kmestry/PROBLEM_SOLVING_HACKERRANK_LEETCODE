package com.leetcode;

public class IsPowerOF4 {


    boolean result;

    public static void main(String[] args) {
        boolean result = new IsPowerOF4().isPowerOfFour(100);
        System.out.println(result);
    }

    public boolean isPowerOfFour(int num) {

        if (num == 0)
            return false;

        if (num == 1)
            result = true;

        if (num % 4 == 0)
            result = isPowerOfFour(num / 4);


        return result;
    }

}
