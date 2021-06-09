package com.geeksforgeeks.strings;

public class AnagramSearchEfficient {

    private static final int CHARS_LENGTH = 128;

    public static void main(String[] args) {
        AnagramSearchEfficient anagramSearchEfficient = new AnagramSearchEfficient();
        int result = anagramSearchEfficient.search("for", "forxxorfxdofr");
        System.out.println(result);
    }

    //sliding window ,
    private int search(String pat, String txt) {
        // code here
        //txt = forxxorfxdofr
        // pat = for

        int count = 0;
        int pointerLeft = 0;
        int pointerRight = pat.length();

        char[] charsPattern = new char[128];
        char[] charsTxt = new char[128];

        for (int i = 0; i < pat.length(); i++) {
            charsPattern[pat.charAt(i)]++;
        }
        for (int i = 0; i < pat.length(); i++) {
            charsTxt[txt.charAt(i)]++;
        }
        //check if first substring is equal
        if (areCharArraysSame(charsPattern, charsTxt)) {
            count++;
        }
        while (pointerRight < txt.length()) {
            charsTxt[txt.charAt(pointerLeft)]--;
            charsTxt[txt.charAt(pointerRight)]++;
            if (areCharArraysSame(charsPattern, charsTxt)) count++;
            pointerLeft++;
            pointerRight++;
        }
        return count;


    }

    private boolean areCharArraysSame(char[] charsPattern, char[] charsTxt) {
        for (int i = 0; i < CHARS_LENGTH; i++) {
            if (charsPattern[i] != charsTxt[i]) {
                return false;
            }
        }
        return true;
    }
}
