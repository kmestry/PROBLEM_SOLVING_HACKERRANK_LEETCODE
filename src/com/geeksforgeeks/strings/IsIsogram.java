package com.geeksforgeeks.strings;

public class IsIsogram {

    static boolean isIsogram(String data) {
        //Your code here
        char[] ch = new char[128];

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            ch[c]++;

            if (ch[c] > 1) {
                return false;
            }
        }

        return true;
    }
}
