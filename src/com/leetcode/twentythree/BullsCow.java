package com.leetcode.twentythree;

import java.util.HashMap;
import java.util.Map;

public class BullsCow {

    public static void main(String[] args) {
        BullsCow bullsCow = new BullsCow();
        bullsCow.getHint("1123"
                , "0111");
    }

    private static void reduceCount(Map<Character, Integer> guessMap, char currChar) {
        if (guessMap.containsKey(currChar) && guessMap.get(currChar) > 1) {
            guessMap.put(currChar, guessMap.get(currChar) - 1);
        } else if (guessMap.containsKey(currChar) && guessMap.get(currChar) <= 1) {
            guessMap.remove(currChar);
        }
    }

    private static void createMap(String secret, Map<Character, Integer> secMap, int i) {
        char c = secret.charAt(i);

        if (secMap.containsKey(c)) {
            secMap.put(c, secMap.get(c) + 1);
        } else {
            secMap.put(c, 1);
        }
    }

    public String getHint(String secret, String guess) {

        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {

            createMap(secret, secretMap, i);
        }
        for (int i = 0; i < guess.length(); i++) {

            createMap(guess, guessMap, i);
        }

        StringBuilder sb = new StringBuilder();

        int b = 0;
        for (int i = 0; i < secret.length(); i++) {
            char currChar = secret.charAt(i);
            if (currChar == guess.charAt(i)) {
                b++;
                reduceCount(guessMap, currChar);

                reduceCount(secretMap, currChar);
            }
        }
        sb.append(b).append("A");


        int cow = 0;
        for (Map.Entry<Character, Integer> entry : guessMap.entrySet()) {
            char guessChar = entry.getKey();

            if (secretMap.containsKey(guessChar)) {
                cow += Math.min(secretMap.get(guessChar), entry.getValue());

            }
        }

        sb.append(cow).append("B");
        return sb.toString();


    }
}
