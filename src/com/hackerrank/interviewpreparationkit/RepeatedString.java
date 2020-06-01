package com.hackerrank.interviewpreparationkit;

public class RepeatedString {


    // Complete the repeatedString function below.
    //aba
    //10
    //string are abaabaabaa. Because there are  7 a's, we print 7 on a new line.
    static long repeatedString(String s, long n) {
        String resultString = "";
        long counterOfChar = 0;
        s = s.toLowerCase();

        if (s.length() == 1 && s.contains("a")) {
            counterOfChar = n;
            return counterOfChar;
        }

        if (s.length() > 1 && s.contains("a")) {
            String limitedString = "";
            while (true) {
                limitedString += s;
                if (limitedString.length() >= n) {
                    break;
                }
            }
            resultString = limitedString.substring(0, (int) n);
        }

        System.out.println(resultString);

        if (resultString.length() == n) {
            char[] charArray = resultString.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == 'a') {
                    counterOfChar++;
                }
            }
        }
        System.out.println(counterOfChar);
        return counterOfChar;


    }

    /*
    *
    *        aab
            882787
        Expected Output
             588525
             *
             *     ababa   3
    * */

    public static void main(String[] args) {

        repeatedString("bcbccacaacbbacabcabccacbccbababbbbabcccbbcbcaccababccbcbcaabbbaabbcaabbbbbbabcbcbbcaccbccaabacbbacbc", Long.parseLong("649606239668"));
        //repeatedString("aab", 882787);
    }
}
