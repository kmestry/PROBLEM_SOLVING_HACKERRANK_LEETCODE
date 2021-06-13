package com.geeksforgeeks.strings;

public class ModifiedString {

    public static void main(String[] args) {
        long result = ModifiedString.modified("aaaaa");
        System.out.println(result);
    }

    //aaaaa
    // add a alphabet after every 2 consecutive same chars and then
    // u get aaba..after that start checking for 3 consecutive same chars from aab(a) bracketed character
    public static long modified(String str) {
        // Your code here
        //aaaa

        long count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) {
                count++;
                i = i + 1;
            }
        }
        return count;
    }
}
