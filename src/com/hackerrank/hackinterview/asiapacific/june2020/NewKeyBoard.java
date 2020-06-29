package com.hackerrank.hackinterview.asiapacific.june2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result2 {
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

    public static String receivedText(String receivedText) {
        // WRITE DOWN YOUR CODE HERE
        boolean isNumLockEnabled = true;
        boolean isHomeKeyPressed = false;
        StringBuilder resultString = new StringBuilder();
        StringBuilder homeKeyString = new StringBuilder();
        int homePointer = 0;

        for (int i = 0; i < receivedText.length(); i++) {

            String character = String.valueOf(receivedText.charAt(i));

            if (character.matches("[0-9]") && !isNumLockEnabled) {

                //donothing
            } else {

                if (character.matches("[#*<>]")) {

                    switch (character) {
                        case BACKSPACE:
                            if (resultString.length() != 0 && !isHomeKeyPressed) {
                                resultString.deleteCharAt(resultString.length() - 1);

                            } else if (homeKeyString.length() != 0 && isHomeKeyPressed && homePointer >= 0) {
                                homeKeyString.deleteCharAt(homePointer);
                                homePointer--;

                            }
                            break;

                        case HOME_KEY:

                            homePointer = -1;


                            isHomeKeyPressed = true;
                            break;

                        case END_KEY:
                            isHomeKeyPressed = false;
                            break;

                        case NUMLOCK_KEY:
                            isNumLockEnabled = !isNumLockEnabled;
                            break;

                        default:
                            throw new IllegalArgumentException("illegal character");
                    }
                } else {

                    if (isHomeKeyPressed) {
                        boolean isDigit = Character.isDigit(receivedText.charAt(i));
                        if (homeKeyString.length() == 0) {
                            if (!isDigit || isNumLockEnabled) {
                                homeKeyString.insert(0, receivedText.charAt(i));
                                homePointer = homeKeyString.length() - 1;
                            }
                        } else {
                            if (homePointer == -1) {
                                if (!isDigit || isNumLockEnabled) {
                                    homeKeyString.insert(0, receivedText.charAt(i));
                                    homePointer = 0;
                                }

                            } else if (!isDigit || (isNumLockEnabled && homePointer >= 0)) {
                                homeKeyString.insert(homePointer + 1, receivedText.charAt(i));
                                homePointer = homePointer + 1;
                            }
                        }

                    } else {
                        appendCharacter(receivedText, isNumLockEnabled, resultString, i);
                    }
                }
            }

        }

        return homeKeyString.append(resultString).toString();

    }

    private static void appendCharacter(String receivedText, boolean isNumLockEnabled, StringBuilder resultString, int i) {
        boolean isDigit = Character.isDigit(receivedText.charAt(i));
        if (!isDigit || isNumLockEnabled) {
            resultString.append(receivedText.charAt(i));
        }
    }

}

//1#<a2>*<bc*>#<*
//ab<cd*<*
//a<**bad<><abc*<gt*
//a<*ba>ab<*cd<ac>bd*<ac*     === aaccdbaaabb
//a>bc<*ade>bdefg**>cd>#1*
//result = adeabcbdec   adeabcbdec
//ab<cd<ef**  === cdab
public class NewKeyBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        String result = Result2.receivedText(S);


        System.out.println("result = " + result);

        bufferedReader.close();
    }
}
