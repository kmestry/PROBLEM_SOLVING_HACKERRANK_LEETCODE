package com.hackerrank.hackinterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {
    public static final String CONSTANT_BINARY_ONE = "1";

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER d
     */

          /*  1001000010
              3  */

    public static int minimumMoves(String s, int d) {
        // Write your code here
        int initialSubStringLength = d;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {

            if (d > s.length()) {
                break;
            }

            String subString = s.substring(i, d);
            //System.out.println("subString = " + subString);
            if (!subString.contains("1")) {
                StringBuilder stringBuilder = new StringBuilder(s);
                stringBuilder.setCharAt(i + initialSubStringLength - 1, '1');
                //s = s.substring(0, i + initialSubStringLength - 1) + CONSTANT_BINARY_ONE + s.substring(i + initialSubStringLength);
                s = stringBuilder.toString();

                counter++;
            }

            d++;

        }

        return counter;
    }


}

public class ValidBinaryString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.minimumMoves(s, d);

        System.out.println("result = " + result);

        bufferedReader.close();
    }
}
