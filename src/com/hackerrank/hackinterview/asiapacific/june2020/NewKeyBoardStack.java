package com.hackerrank.hackinterview.asiapacific.june2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class ResultStack2 {

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
        boolean isHomeKeyPressed = false;
        int pointer = -1;
        StringBuilder resultString = new StringBuilder();
        StringBuilder homeString = new StringBuilder();

        Deque<Character> characterDeque = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++) {
            String character = Character.toString(S.charAt(i));
            if (character.matches("[#*<>]")) {

                switch (character) {
                    case BACKSPACE:
                        if (resultString.length() > 0 && pointer >= 0 && !isHomeKeyPressed) {
                            resultString.deleteCharAt(pointer);
                            pointer--;
                        } else {

                            if (pointer >= 0) {
                                homeString.deleteCharAt(pointer);
                                pointer--;
                            }
                        }
                        break;

                    case HOME_KEY:

                        pointer = -1;
                        isHomeKeyPressed = true;


                        break;

                    case END_KEY:

                        pointer = resultString.length() - 1;
                        isHomeKeyPressed = false;
                        break;

                    case NUMLOCK_KEY:
                        isNumLockEnabled = !isNumLockEnabled;
                        break;

                    default:
                        throw new IllegalArgumentException("illegal character");
                }
            } else {

                if (!isHomeKeyPressed) {
                    if (isNumLockEnabled) {
                        resultString.append(S.charAt(i));
                        pointer = pointer + 1;


                    } else {
                        if (character.matches("[^0-9]")) {
                            resultString.append(S.charAt(i));
                            pointer = pointer + 1;
                        }
                    }

                } else {
                    if (pointer == -1) {
                        characterDeque.addFirst(S.charAt(i));
                        pointer = pointer + 1;
                    } else {
                        if (character.matches("[^0-9]")) {
                            characterDeque.add(S.charAt(i));
                            pointer = pointer + 1;
                        }
                    }


                    while (!characterDeque.isEmpty()) {
                        homeString.append(characterDeque.pollFirst());
                    }
                    if (homeString.length() > 0) {
                        resultString = homeString.append(resultString);
                    }
                    homeString = new StringBuilder();


                }


            }
        }

        return resultString.toString();

    }

}

public class NewKeyBoardStack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        String result = ResultStack2.receivedText(S);

        System.out.println(result);

        bufferedReader.close();
    }
}
//MJYiy1XbOmsnKHwP6Z9U1Y6U4hukobC1PHtJjIoDo8xxM9ImTbu85PSBctlfxeHyK