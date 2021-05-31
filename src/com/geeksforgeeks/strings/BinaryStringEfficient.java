package com.geeksforgeeks.strings;

public class BinaryStringEfficient {

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.equals()*/
    }

    public static int binarySubstring(int a, String str) {
        // Your code here
        int counterOnes = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                counterOnes++;
            }
        }

        int val = ((counterOnes * (counterOnes - 1)));

        return val / 2;
    }
}
