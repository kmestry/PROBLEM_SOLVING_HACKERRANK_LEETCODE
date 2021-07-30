package com.hackerrank.athena;

import java.util.Arrays;
import java.util.List;

public class Romanizer {

    public static void main(String[] args) {
        Romanizer romanizer = new Romanizer();
        romanizer.intToRoman(75);
    }

    public String intToRoman(int num) {
        List<Pair> pair = Arrays.asList(new Pair(1000, "M"), new Pair(900, "CM"),
                new Pair(500, "D"), new Pair(100, "C"),
                new Pair(50, "L"), new Pair(10, "X"),
                new Pair(5, "V"), new Pair(1, "I"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pair.size(); i++) {

            while (num >= pair.get(i).getKey()) {
                sb.append(pair.get(i).getValue());
                num -= pair.get(i).getKey();
            }
        }

        return sb.toString();
    }

}

class Pair {
    int key;
    String value;

    Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}