package com.geeksforgeeks.strings;

public class LeftMostRepeatingCharacterOnePass {
    public static void main(String[] args) {
        LeftMostRepeatingCharacterOnePass leftmostRepeatingCharacter = new LeftMostRepeatingCharacterOnePass();
        int index = leftmostRepeatingCharacter.findLeftMostRepeatingCharacter("geeksforgeeks");
        System.out.println(index);
    }


    private int findLeftMostRepeatingCharacter(String input) {

        boolean[] visited = new boolean[128]; // assuming 128 ascii characters

        int result = -1;
        for (int i = input.length() - 1; i >= 0; i--) {

            if (visited[input.charAt(i)]) {
                result = i;
            } else {
                visited[input.charAt(i)] = true;
            }
        }

        return result;
    }
}
