package com.leetcode.twentythree;

public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings
                = new IsomorphicStrings();

        isomorphicStrings.isIsomorphic("paper", "title");
    }

    public boolean isIsomorphic(String s, String t) {

        int[] arrS = new int[128];
        int[] arrT = new int[128];

        for (int i = 0; i < s.length(); i++) {
            arrS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arrT[t.charAt(i) - 'a']++;
        }

        int sI = 0;
        int tI = 0;

        int val1 = 0;
        int val2 = 0;

        while (sI < arrS.length || tI < arrT.length) {

            if (val1 != 0 && val2 != 0 && val1 != val2) return false;

            if (val1 != 0 && val2 != 0) {
                if (arrS[sI] != 0) {
                    val1 = arrS[sI];
                }
                if (arrT[tI] != 0) {
                    val2 = arrT[tI];
                }
                sI++;
                tI++;
            } else if (val1 != 0 && val2 == 0) {
                if (arrT[tI] != 0) {
                    val2 = arrT[tI];
                }
                tI++;
            } else {
                if (arrS[sI] != 0) {
                    val1 = arrS[sI];
                }
                sI++;
            }


        }

        return true;
    }
}
