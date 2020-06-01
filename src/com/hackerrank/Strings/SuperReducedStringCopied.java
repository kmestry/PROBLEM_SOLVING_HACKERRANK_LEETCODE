package com.hackerrank.Strings;

import java.util.Scanner;

public class SuperReducedStringCopied {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        StringBuffer s = new StringBuffer(stdin.nextLine());
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                s.delete(i - 1, i + 1);
                i = 0;
            }
        }
        if (s.length() == 0) System.out.println("Empty String");
        else System.out.println(s);
    }
}

