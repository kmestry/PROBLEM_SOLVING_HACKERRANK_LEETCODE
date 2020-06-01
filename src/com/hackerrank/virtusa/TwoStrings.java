package com.hackerrank.virtusa;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        char[] firstStringArray = s1.toLowerCase().toCharArray();
        char[] secondStringArray = s2.toLowerCase().toCharArray();

        for (int i = 0; i < firstStringArray.length; i++) {
            for (int j = 0; j < secondStringArray.length; j++) {
                if (firstStringArray[i] == secondStringArray[j]) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world"));
    }
}
