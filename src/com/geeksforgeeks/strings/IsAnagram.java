package com.geeksforgeeks.strings;

public class IsAnagram {

    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b) {


        // characters in both string same count
        //dog ogd  ;; - 'a'
        // Your code here

        char[] array = new char[128];

        for (int i = 0; i < a.length(); i++) {
            array[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            array[b.charAt(i)]--;
        }

        for (char c : array) {
            if ((int) c != 0) {
                return false;
            }
        }

        return true;
    }
}
