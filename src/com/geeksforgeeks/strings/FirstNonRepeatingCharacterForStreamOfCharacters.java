package com.geeksforgeeks.strings;

import java.util.Arrays;

public class FirstNonRepeatingCharacterForStreamOfCharacters {
    static final int CHAR = 256;

    static int nonRep(String S) {

        int[] ch = new int[256];
        Arrays.fill(ch, -1);
        for (int i = 0; i < S.length(); i++) {
            if (ch[S.charAt(i)] == -1) {
                ch[S.charAt(i)] = i;
            } else {
                ch[S.charAt(i)] = -2;
            }
        }

        int res = Integer.MAX_VALUE;
        char c = '$';
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 0 && ch[i] < res) {
                res = ch[i];
                c = (char) ch[i];
            }

        }

        return c;
    }

    public static void main(String[] args) {
        String str = "abbcbda";
        System.out.println("Index of leftmost non-repeating element:");
        System.out.println(nonRep(str));
    }
}
