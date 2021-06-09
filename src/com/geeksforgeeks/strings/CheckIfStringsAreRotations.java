package com.geeksforgeeks.strings;

public class CheckIfStringsAreRotations {
    public static void main(String[] args) {
        CheckIfStringsAreRotations checkIfStringsAreRotations = new CheckIfStringsAreRotations();
        boolean result = checkIfStringsAreRotations.checkIfRotation("ABCD", "CDAB");
        //ABCDABCD
    }

    // ABCD , CDAB
    // BCDA
    // CDAB
    // DABC
    // ABCD

    //Brute Force . TLE GFG
    private boolean checkIfRotation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        String concatenatedString = s1.repeat(2);


        return concatenatedString.contains(s2);
    }

    private boolean checkIfRotationBruteForce(String s1, String s2) {

        int length = s1.length();

        StringBuilder sb = new StringBuilder();
        String s1Copy = s1;
        for (int j = 0; j < length; j++) {
            for (int i = 1; i < length; i++) {
                sb.append(s1Copy.charAt(i));
            }
            sb.append(s1Copy.charAt(0));
            s1Copy = sb.toString();
            if (sb.toString().equals(s2)) {
                return true;
            }
            sb.setLength(0);

        }

        return false;
    }
}
