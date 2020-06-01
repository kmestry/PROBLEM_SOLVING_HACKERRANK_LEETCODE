package com.hackerrank.interviewpreparationkit;

public class RepeatedStringOptimized {

    static long repeatedString(String s, long n) {
        long counterOfCharA = 0;
        if (s.contains("a")) {
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == 'a') {

                    counterOfCharA++;
                }

            }

            long restOfAs = n % s.length();

            long basicAs = n - restOfAs;
            long multiplication = basicAs * counterOfCharA;
            long result_basic = (multiplication) / (s.length());


            String restA = s.substring(0, (int) restOfAs);


            char[] restOfArray = restA.toCharArray();
            int restOfACounter = 0;
            for (int i = 0; i < restOfArray.length; i++) {
                if (restOfArray[i] == 'a') {

                    restOfACounter++;
                }
            }

            System.out.println(result_basic + restOfACounter);
            return result_basic + restOfACounter;
        }
        return 0;
    }


    /*
    *     beeaabc

    711560125001

Expected Output
Download
    203302892858
    *
    * */


    /*
    *
    *     bcbccacaacbbacabcabccacbccbababbbbabcccbbcbcaccababccbcbcaabbbaabbcaabbbbbbabcbcbbcaccbccaabacbbacbc

    649606239668

Expected Output
Download

    162401559918
    * */

    public static void main(String[] args) {
        //output: 168329872486
        // repeatedString("aedbdaeaddadddcedcbbabdccbecaecaccdbebeeadadcaabbaabbaeeeecaddbcdecbbdccdebaaebecdaaabbcdeccbabaabce", Long.parseLong("731869010806"));

        //repeatedString("beeaabc", Long.parseLong("711560125001"));

        repeatedString("jdiacikk", Long.parseLong("899491"));

        // repeatedString("bcbccacaacbbacabcabccacbccbababbbbabcccbbcbcaccababccbcbcaabbbaabbcaabbbbbbabcbcbbcaccbccaabacbbacbc", Long.parseLong("649606239668"));
    }
}
