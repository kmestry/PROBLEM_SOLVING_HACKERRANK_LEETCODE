package com.hackerrank.hackinterview.asiapacific.june2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Result {

    public static final String BACKSPACE = "*";
    public static final String HOME_KEY = "<";
    public static final String END_KEY = ">";
    public static final String NUMLOCK_KEY = "#";

    /*
     * Complete the 'receivedText' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING S as parameter.
     */

    public static String receivedText(String S) {
        // WRITE DOWN YOUR CODE HERE
        boolean isNumLockEnabled = true;
        Deque<Character> characterQueue = new ArrayDeque<>();
        int pointer = -1;
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            String character = Character.toString(S.charAt(i));
            if (character.matches("[#*<>]")) {

                switch (character) {
                    case BACKSPACE:
                        if (resultString.length() > 0 && pointer >= 0) {
                            resultString.deleteCharAt(pointer);
                            pointer--;
                        }
                        break;

                    case HOME_KEY:

                        pointer = -1;

                        break;

                    case END_KEY:
                        pointer = resultString.length() - 1;
                        break;

                    case NUMLOCK_KEY:
                        isNumLockEnabled = !isNumLockEnabled;
                        break;

                    default:
                        throw new IllegalArgumentException("illegal character");
                }
            } else {

                if (isNumLockEnabled) {
                    resultString.insert(pointer + 1, S.charAt(i));
                    pointer = pointer + 1;


                } else {
                    if (character.matches("[^0-9]")) {
                        resultString.insert(pointer + 1, S.charAt(i));
                        pointer = pointer + 1;
                    }

                }


            }
        }

        return resultString.toString();

    }

}

public class NewKeyBoardOptimized {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        String result = Result.receivedText(S);

        System.out.println("result = " + result);

        bufferedReader.close();
    }
}
