package com.geeksforgeeks.strings;

public class PangramChecking {

    public static boolean checkPangram(String str) {
        // your code here
        char[] ch = new char[128];

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            ch[str.charAt(i)]++;
        }

        for (int i = 97; i < 97 + 26; i++) {
            if (ch[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
