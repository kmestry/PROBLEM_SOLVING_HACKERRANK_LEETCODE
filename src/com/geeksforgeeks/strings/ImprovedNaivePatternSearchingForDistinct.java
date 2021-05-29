package com.geeksforgeeks.strings;

import java.util.ArrayList;
import java.util.List;

public class ImprovedNaivePatternSearchingForDistinct {

    public static void main(String[] args) {

        ImprovedNaivePatternSearchingForDistinct imp = new ImprovedNaivePatternSearchingForDistinct();
        /*  List<Integer> list_0 = imp.naivePatternSearch("ABCABCD", "ABCD");*/

        List<Integer> list_1 = imp.naivePatternSearch("GEEKSFORGEEKS", "EKS");
        List<Integer> list_4 = imp.naivePatternSearch("ABCEABEFABCD", "ABCD");
      /*  List<Integer> list_2 = imp.naivePatternSearch("ABCAAAD", "ABD");

        List<Integer> list_3 = imp.naivePatternSearch("ABCABCDABCD", "ABCD");*/
        //  System.out.println(list_0);
        System.out.println(list_1);
        System.out.println(list_4);
      /*  System.out.println(list_2);
        System.out.println(list_3);*/
    }

    private List<Integer> naivePatternSearch(String s, String pattern) {

        List<Integer> list = new ArrayList<>();
        int pointerS = 0;
        while (pointerS < s.length()) {

            int countP = 0;
            int loopIndex = pattern.length() + pointerS;
            int nextPointerS = pointerS;
            for (int i = pointerS; i < loopIndex; i++) {

                if (s.charAt(i) != pattern.charAt(countP)) {
                    break;
                }
                countP++;
                nextPointerS++;

            }
            if (countP == pattern.length()) {
                list.add(pointerS);
                pointerS = loopIndex;
            } else if (nextPointerS > pointerS) {
                pointerS = nextPointerS;
            } else {
                pointerS++;
            }

        }

        return list;


    }
}
