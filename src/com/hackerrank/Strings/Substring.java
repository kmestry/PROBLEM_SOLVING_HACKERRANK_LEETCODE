package com.hackerrank.Strings;

public class Substring {
    // Complete the stringConstruction function below.
    static int stringConstruction(String s) {
        String p = "";
        int dollarCost = 0;
        String[] stringArray = s.split("");
        if (s.length() > 0) {
            for (int i = 0; i < stringArray.length; i++) {
                if (p.contains(stringArray[i])) {

                } else {
                    dollarCost++;
                    p += stringArray[i];
                }
            }

        }
        System.out.println("dollarCost = " + dollarCost);
        return dollarCost;

    }

    public static void main(String[] args) {

        stringConstruction("abcd");
        stringConstruction("abab");
    }
}
