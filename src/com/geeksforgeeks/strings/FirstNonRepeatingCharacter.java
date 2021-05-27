package com.geeksforgeeks.strings;

public class FirstNonRepeatingCharacter {
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S) {
        //Your code here
        char[] ch = new char[256];

        char result = '$';
        for (int i = 0; i < S.length(); i++) {
            ch[S.charAt(i)]++;
        }

        for (int i = 0; i < S.length(); i++) {
            if (ch[S.charAt(i)] == 1) {
                return S.charAt(i);
            }
        }

        return result;
    }
}
