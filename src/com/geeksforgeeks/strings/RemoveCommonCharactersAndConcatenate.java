package com.geeksforgeeks.strings;

public class RemoveCommonCharactersAndConcatenate {

    public static String concatenatedString(String s1, String s2) {
        // Your code here

        char[] ch1 = new char[128];
        char[] ch2 = new char[128];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            ch1[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            ch2[c]++;
        }

        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] > 0 && ch2[i] > 0) {
                ch1[i] = 0;
                ch2[i] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (ch1[c] > 0) {
                sb.append(c);
            }
        }


        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (ch2[c] > 0) {
                sb.append(c);
            }
        }
        return sb.toString().length() == 0 ? "-1" : sb.toString();
    }
}
