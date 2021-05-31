package com.geeksforgeeks.strings;

public class FirstRepeatingCharacterLeftMost {

    //Function to find repeated character whose first appearance is leftmost.
    static int repeatedCharacter(String S) {
        // add your code here

        char[] ch = new char[128];

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            ch[c]++;
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (ch[c] > 1) {
                return i;
            }
        }
        return -1;
    }
}
