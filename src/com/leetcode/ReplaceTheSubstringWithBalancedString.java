package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReplaceTheSubstringWithBalancedString {

    public static void main(String[] args) {
        ReplaceTheSubstringWithBalancedString replaceTheSubstringWithBalancedString = new ReplaceTheSubstringWithBalancedString();
        //  int result = replaceTheSubstringWithBalancedString.balancedString("WWEQERQWQWWRWWERQWEQ");
        int result = replaceTheSubstringWithBalancedString.balancedString("QQQWEEER");
        //int result = replaceTheSubstringWithBalancedString.balancedString("QQWE");
        // q 3 . w 1  .e 3 . r 1

        System.out.println(result);

    }

    public int balancedString(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int i = 0;
        int result = s.length();
        int k = s.length() / 4;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            map.put(ch, map.get(ch) - 1);

            while (i < s.length()
                    && (map.get('Q') != null ? map.get('Q') : 0) <= k &&
                    (map.get('W') != null ? map.get('W') : 0) <= k &&
                    (map.get('E') != null ? map.get('E') : 0) <= k &&
                    (map.get('R') != null ? map.get('R') : 0) <= k) {

                result = Math.min(result, j - i + 1);
                if (result == 0) {
                    return 0;
                }

                char iChar = s.charAt(i);
                map.put(iChar, map.get(iChar) + 1);
                i++;
            }
        }

        return result;
    }
}
