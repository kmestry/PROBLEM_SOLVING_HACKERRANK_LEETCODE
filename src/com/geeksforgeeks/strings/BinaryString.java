package com.geeksforgeeks.strings;

public class BinaryString {

    // gives TLE . but approach is correct.
    public static int binarySubstring(int a, String str) {
        // Your code here
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == '1') {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }
}
