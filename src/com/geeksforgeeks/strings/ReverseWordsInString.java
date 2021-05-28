package com.geeksforgeeks.strings;

public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        String result = reverseWordsInString.reverseWords("i.like.this.program.very.much");

        //new StringBuilder(result).reverse();

        String s = "";
        System.out.println(result);
    }

    String reverseWords(String S) {
        // code here
        String[] strings = S.split("\\.");

        int left = 0;
        int right = strings.length - 1;

        while (left <= right) {
            String s1 = strings[left];
            String s2 = strings[right];

            strings[right] = s1;
            strings[left] = s2;
            left++;
            right--;
        }

        StringBuilder result = new StringBuilder();


        for (int i = 0; i < strings.length; i++) {


            result.append(strings[i]);
            if (i < strings.length - 1)
                result.append(".");
        }


        return result.toString();
    }
}
