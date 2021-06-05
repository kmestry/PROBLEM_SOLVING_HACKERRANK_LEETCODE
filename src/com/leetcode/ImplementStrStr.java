package com.leetcode;

public class ImplementStrStr {


    private static final int PRIME = 2;

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        ImplementStrStr implementStrStr = new ImplementStrStr();
//        "abbbbbaabbaabaabbbaaaaabbabbbabbbbbaababaabbaabbbbbababaababbbbaaabbbbabaabaaaabbbbabbbaabbbaabbaaabaabaaaaaaaa"
//        "abbbaababbbabbbabbbbbabaaaaaaabaabaabbbbaabab"
        int result = implementStrStr.strStr("abbbbbaabbaabaabbbaaaaabbabbbabbbbbaababaabbaabbbbbababaababbbbaaabbbbabaabaaaabbbbabbbaabbbaabbaaabaabaaaaaaaa", "abbbaababbbabbbabbbbbabaaaaaaabaabaabbbbaabab");
        System.out.println(result);
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;

        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        int lengthNeedle = needle.length();

        long needleHashCode = calculateHash(needle);
        String firstSubString = haystack.substring(0, lengthNeedle);
        long firstHashCode = calculateHash(firstSubString);

        if (needleHashCode == firstHashCode) {
            if (validateHashHits(needle, haystack, 0))
                return 0;
        }

        int pointer1 = 0;
        int pointer2 = lengthNeedle;
        long currentHash = firstHashCode;

        while (pointer2 < haystack.length()) {

            long rollingHash = recalculateHash(currentHash, haystack.charAt(pointer1), haystack.charAt(pointer2), lengthNeedle);

            if (rollingHash == needleHashCode) {
                if (validateHashHits(needle, haystack, pointer1 + 1))
                    return pointer1 + 1;
            }
            currentHash = rollingHash;
            pointer1++;
            pointer2++;
        }

        return -1;


    }

    private boolean validateHashHits(String needle, String haystack, int startPointer) {

        for (int i = 0; i < needle.length(); i++) {
            if (needle.charAt(i) != haystack.charAt(startPointer)) {
                return false;
            }
            startPointer++;
        }
        return true;
    }

    private long recalculateHash(long currentHash, char deletedChar, char addedChar, int lengthNeedle) {

        long result = currentHash;
        result -= (int) deletedChar;

        //divide by prime
        result /= PRIME;

        //add power of length of needle -1 to result to get rolling hash.
        result += ((int) addedChar * Math.pow(PRIME, lengthNeedle - 1));

        return result;

    }

    private long calculateHash(String needle) {

        //1 * math.pow(
        char[] chars = needle.toCharArray();
        int power = 0;
        long result = 0L;

        for (int i = 0; i < chars.length; i++) {
            result += ((int) chars[i] * (Math.pow(PRIME, power)));
            power++;
        }

        return result;
    }
}
