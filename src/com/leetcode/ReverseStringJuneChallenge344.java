package com.leetcode;

public class ReverseStringJuneChallenge344 {

    public static void main(String[] args) {
        String s = "kunal";
        String res = new ReverseStringJuneChallenge344().reverseString(s.toCharArray());
        System.out.println("res = " + res);

    }

    public String reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }

        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            s1.append(s[i]);
        }

        return s1.toString();


    }
}
