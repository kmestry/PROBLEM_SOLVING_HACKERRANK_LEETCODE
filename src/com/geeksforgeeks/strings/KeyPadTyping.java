package com.geeksforgeeks.strings;

import java.util.HashMap;
import java.util.Map;

public class KeyPadTyping {
    public static void main(String[] args) {
        String result = KeyPadTyping.printNumber("geeksforgeeks", 13);
        System.out.println(result);
    }

    public static String printNumber(String s, int n) {
        //Your code here

        Map<Character, Integer> map = new HashMap<>();

        int counter = 0;
        int start = 2;
        for (int i = 97; i < 123; i++) {

            if (start < 7 || start == 8) {
                if (counter < 4) {
                    map.put((char) i, start);
                    counter++;
                }
                if (counter == 3) {
                    start++;
                    counter = 0;
                }
            } else if (start == 7 || start == 9) {
                if (counter < 5) {
                    map.put((char) i, start);
                    counter++;
                }
                if (counter == 4) {
                    start++;
                    counter = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(s.charAt(i)));
        }

        return sb.toString();


    }
}
