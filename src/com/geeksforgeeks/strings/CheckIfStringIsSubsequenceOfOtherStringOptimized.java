package com.geeksforgeeks.strings;

public class CheckIfStringIsSubsequenceOfOtherStringOptimized {

    public static boolean isSubSequence(String A, String B) {
        //code here
        int pointerA = 0;
        int pointerB = 0;

        while (pointerA < A.length() && pointerB < B.length()) {
            char cA = A.charAt(pointerA);
            char cB = B.charAt(pointerB);

            if (cA == cB) {
                pointerA++;
                pointerB++;
            } else {
                pointerB++;
            }
        }
        return pointerA >= A.length();
    }
}
