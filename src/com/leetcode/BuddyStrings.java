package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuddyStrings {

    public static void main(String[] args) {
        boolean res = new BuddyStrings().buddyStrings("ab", "ab");
        System.out.println("res = " + res);
    }

    public boolean buddyStrings(String A, String B) {


        if ("".equals(A) || "".equals(B) || A.length() < 2 || A.length() != B.length()) {
            return false; // if A is "" or "a"(length is 1) we cannot do swap.
            // A and B are of different length then too, A will never be equal to B after swapping.
        }


        if (A.equals(B)) {
            //condition when A is aaaaa B is aaaaa
            //if a equals b and all chars of a are same.
            //swapping won't change the string A.
            //equal strings can also be ab ab. here swapping will result in false result
            boolean isSameChars = true;

            for (int i = 0; i < A.length() - 1; i++) {
                if (A.charAt(i) != A.charAt(i + 1)) {
                    isSameChars = false;
                    break;
                }
            }

            if (isSameChars) {
                return true;
            } else {
                // case when A equals B.
                // eg : abab ;abab
                //we need to swap once always.. so the logic is to find if there are any
                //duplicate chars , if yes swapping them will not affect the result and hence.
                // A will be equal to B even after swapping 1 char which is duplicate or repeated

                Map<Character, Integer> map = new HashMap<>();

                for (int i = 0; i < A.length(); i++) {
                    if (map.containsKey(A.charAt(i))) {
                        map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
                    } else {
                        map.put(A.charAt(i), 1);
                    }
                }
                boolean isFound = false;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > 1) {
                        isFound = true;
                        break;
                    }
                }
                return isFound;

            }
        }

        //situation when A is not equal to B.

        List<Integer> indexPositionDifferentList = new ArrayList<>();

        //find the indexes where the chars differ.
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                indexPositionDifferentList.add(i);
            }
        }

        // as we can swap only once , we wil check only when list has 2 elements.
        if (indexPositionDifferentList.size() == 2) {

            char[] chars = A.toCharArray();

            final Integer index1 = indexPositionDifferentList.get(0);
            final Integer index2 = indexPositionDifferentList.get(1);

            char temp1 = chars[index1];
            char temp2 = chars[index2];

            //swap chars at the index position in list
            chars[index1] = temp2;
            chars[index2] = temp1;


            //after swapping check if A and B are equal.
            StringBuilder stringBuilder = new StringBuilder();
            for (char aChar : chars) {
                stringBuilder.append(aChar);
            }


            return stringBuilder.toString().equals(B);
        } else {
            return false;
        }
    }
}
