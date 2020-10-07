package com.leetcode;

public class BackSpaceStringCompare {

    //"ab##"
    //"c#d#"

    //"a##c"
    //"#a#c"
    public static void main(String[] args) {
        boolean result = new BackSpaceStringCompare().backspaceCompare("a##c", "#a#c");
        System.out.println("result = " + result);
    }

    public boolean backspaceCompare(String S, String T) {

        StringBuilder sbString1 = new StringBuilder(S);

        for (int i = 0; i < sbString1.length(); i++) {
            char c = sbString1.charAt(i);

            if (c == '#') {

                if (i == 0)
                    sbString1.deleteCharAt(i);
                else
                    sbString1.delete(i - 1, i + 1);

                i = -1;
            }
        }

        StringBuilder sbString2 = new StringBuilder(T);

        for (int i = 0; i < sbString2.length(); i++) {
            char c = sbString2.charAt(i);

            if (c == '#') {

                if (i == 0)
                    sbString2.deleteCharAt(i);
                else
                    sbString2.delete(i - 1, i + 1);

                i = -1;
            }
        }

        return sbString1.toString().equals(sbString2.toString());
    }
}
