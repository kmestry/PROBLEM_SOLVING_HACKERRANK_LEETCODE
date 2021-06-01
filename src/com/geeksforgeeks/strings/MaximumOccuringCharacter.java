package com.geeksforgeeks.strings;

public class MaximumOccuringCharacter {
    public static char getMaxOccuringChar(String line) {
        // Your code here
        char[] ch = new char[128];

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            ch[c]++;
        }

        int maxOccurrence = 0;
        char result = '$';
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] > maxOccurrence) {
                result = (char) i;
                maxOccurrence = ch[i];
            }

        }
        return result;
    }
}
