package com.leetcode;

public class DetectCapital {

    public static void main(String[] args) {

        boolean result = new DetectCapital().detectCapitalUse("AAg");
    }

    //USA , Google, leetcode, FlAg
    public boolean detectCapitalUse(String word) {

        if (word.length() == 1) {
            return true;
        }

        int firstChar = word.charAt(0);
        int secondChar = word.charAt(1);
        //check for all small case
        if (firstChar >= 'a' && firstChar <= 'z') {
            for (int i = 1; i < word.length(); i++) {
                int charAtIndex = word.charAt(i);
                if (!(charAtIndex >= 'a' && charAtIndex <= 'z')) {
                    return false;
                }
            }
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            if (secondChar >= 'a' && secondChar <= 'z') {
                for (int i = 2; i < word.length(); i++) {
                    int charAtIndex = word.charAt(i);
                    if (!(charAtIndex >= 'a' && charAtIndex <= 'z')) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < word.length(); i++) {
                    int charAtIndex = word.charAt(i);
                    if (!(charAtIndex >= 'A' && charAtIndex <= 'Z')) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}

