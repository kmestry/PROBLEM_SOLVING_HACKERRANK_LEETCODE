package com.geeksforgeeks.strings;

public class LeftmostRepeatingCharacter {

    public static void main(String[] args) {
        LeftmostRepeatingCharacter leftmostRepeatingCharacter = new LeftmostRepeatingCharacter();
        int index = leftmostRepeatingCharacter.findLeftMostRepeatingCharacter("geeksforgeeks");
        System.out.println(index);
    }

    // "abbcc"
    private int findLeftMostRepeatingCharacter(String input) {

        char[] chars = new char[128];

        for (int i = 0; i < input.length(); i++) {
            chars[input.charAt(i)]++;
        }

        for (int i = 0; i < input.length(); i++) {
            int counter = chars[input.charAt(i)];
            if (counter > 1) {
                return i;
            }
        }

        return -1;
    }
}

