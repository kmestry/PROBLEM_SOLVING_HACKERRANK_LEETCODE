package com.hackerrank.Strings;

public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {

        String[] charArray = s.split("");
        int camelCaseCounter = 1;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i].matches("[A-Z]")) {
                camelCaseCounter++;
            }

        }
        return camelCaseCounter;

    }

    public static void main(String[] args) {
        System.out.println(camelcase("saveChangesInTheEditor"));
    }
}
