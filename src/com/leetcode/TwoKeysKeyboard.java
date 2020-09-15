package com.leetcode;

public class TwoKeysKeyboard {

    public static void main(String[] args) {

        new TwoKeysKeyboard().minSteps(4);

    }

    public int minSteps(int n) {
        int current = 1;
        int buffer = 0;
        int count = 0;
        while (current < n) {
            int rest = n - current;
            //copy paste .less operations.
            if (rest % current == 0) {
                buffer = current;
                current += buffer;
                count += 2;
            } else {//paste
                current += buffer;
                count++;
            }
        }

        return count;
    }


}
