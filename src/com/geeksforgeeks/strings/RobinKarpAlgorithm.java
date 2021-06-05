package com.geeksforgeeks.strings;

import java.util.ArrayList;
import java.util.List;

public class RobinKarpAlgorithm {

    private static final Integer primeNum = 101;


    public static void main(String[] args) {
        RobinKarpAlgorithm robinKarpAlgorithm = new RobinKarpAlgorithm();
        List<Integer> list_0 = robinKarpAlgorithm.RBSearch("ABCABCD", "ABCD");

        List<Integer> list_1 = robinKarpAlgorithm.RBSearch("GEEKSFORGEEKS", "EKS");
        List<Integer> list_4 = robinKarpAlgorithm.RBSearch("ABCEABEFABCD", "ABCD");
        List<Integer> list_2 = robinKarpAlgorithm.RBSearch("ABCAAAD", "ABD");

        List<Integer> list_3 = robinKarpAlgorithm.RBSearch("ABCABCDABCD", "ABCD");

        System.out.println(list_0);
        System.out.println(list_1);
        System.out.println(list_4);
        System.out.println(list_2);
        System.out.println(list_3);
    }

    List<Integer> RBSearch(String txtToSearch, String pattern) {
        List<Integer> result = new ArrayList<>();
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);

        String firstHashString = txtToSearch.substring(0, pattern.length());
        long firstHashValue = calculateHash(firstHashString);

        if (patternHash == firstHashValue) {
            result.add(0);
        }

        int pointer1 = 0;
        int pointer2 = pattern.length();
        long hashValueTillNow = firstHashValue;
        while (pointer2 < txtToSearch.length()) {
            hashValueTillNow = recalculateHash(hashValueTillNow, txtToSearch.charAt(pointer1),
                    txtToSearch.charAt(pointer2), patternLength);
            if (hashValueTillNow == patternHash) {
                result.add(pointer1 + 1);
            }
            pointer1++;
            pointer2++;
        }


        return result;

    }

    private long recalculateHash(long hashValue, char deletedChar, char addedChar, int patternLength) {

        long hashValueResult = 0;

        hashValueResult = hashValue - (int) deletedChar;
        hashValueResult = hashValueResult / primeNum;

        hashValueResult += (long) ((int) addedChar * Math.pow(primeNum, patternLength - 1));

        return hashValueResult;
    }

    private long calculateHash(String pattern) {
        //abe

        int power = 0;
        char[] chars = pattern.toCharArray();
        long resultHash = 0;

        for (int charVal : chars) {
            int val = (int) (charVal * Math.pow(primeNum, power));
            power++;
            resultHash += val;

        }

        return resultHash;
    }


}
