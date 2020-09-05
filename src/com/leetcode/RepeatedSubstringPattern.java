package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {

        if (s.length() < 2) return false;

        boolean isRepeatingForWindowSize1 = windowSizeLength1Check(s);  //first check if string consist of all same chars.
        if (isRepeatingForWindowSize1) return true; //return true if all chars of string are same.

        List<Integer> list = findCommonFactors(s.length());  // the max substring u need to check will be the length of string/2.
        //Eg: abab .. the max substring to check will be 2 . we dont need to check for length 3 i.e aba as there will no string to compare
        //with it.
        //IMP: to further optimize we need only to check the common factors of string length EG : if length of string is 12 , we need to
        // only check lenghth 2,3,4,6 if any of the length forms perfect string with repeating substrings return true.

        for (Integer length : list) {

            int subStringLength = length;
            String baseString = s.substring(0, subStringLength);  //here we get the first base string of length equal to one of the
            //common factor length. eg: for ababababab base string will be from index 0 to index 1 both inclusive i.e. "ab".. this string will be
            //compared with the substrings for length 2 for the entire string.
            int left = subStringLength;
            int right = left + subStringLength;

            while (right <= s.length()) {

                String checkString = s.substring(left, right);

                if (checkString.equals(baseString)) {

                    if (right == s.length())
                        return true;   //here if we reached the end of string , means we have compared the string till the
                    //end and found the  substring which when repeated forms the original string
                    left = left + subStringLength;
                    right = right + subStringLength;

                } else {
                    break;
                }
            }

        }

        return false;

    }

    //find common factors logic.
    private List<Integer> findCommonFactors(int stringLength) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 2; i <= stringLength / 2; i++) {
            if (stringLength % i == 0) {
                resultList.add(i);
            }
        }

        return resultList;
    }

    //first window of size 1.
    private boolean windowSizeLength1Check(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
