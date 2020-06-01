package com.hackerrank.virtusa;

import java.util.HashSet;
import java.util.Set;

public class TwoStringsOptimized {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        char[] firstStringArray = s1.toLowerCase().toCharArray();
        char[] secondStringArray = s2.toLowerCase().toCharArray();

        //set has advantage that it can only contain 26 elements which are alphabets in english language.
        Set setStringS1 = new HashSet();
        Set setStringS2 = new HashSet();
        for (int i = 0; i < firstStringArray.length; i++) {
            setStringS1.add(firstStringArray[i]);
        }
        for (int i = 0; i < secondStringArray.length; i++) {
            setStringS2.add(secondStringArray[i]);
        }
        setStringS1.retainAll(setStringS2);
        return setStringS1.isEmpty() ? "NO" : "YES";
    }

    public static void main(String[] args) {
        String result = twoStrings("wouldyoulikefries", "abcabcabcabcabcabc");
        System.out.println("result = " + result);
    }
}
