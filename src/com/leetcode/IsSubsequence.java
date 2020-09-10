package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String t = bufferedReader.readLine();
        boolean result = new IsSubsequence().isSubsequence(s, t);
        System.out.println("result = " + result);
    }

    public boolean isSubsequence(String s, String t) {

        int position = -1;
        if (s.length() == 0) return true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean isCharFound = false;
            for (int j = position; j < t.length(); j++) {

                if (j != -1 && ch == t.charAt(j)) {
                    isCharFound = true;
                    position = j + 1;
                    break;
                }
            }
            if (!isCharFound) return false;

        }


        return true;
    }
}
