package com.geeksforgeeks.strings;

public class ReverseWordsInStringInPlace {


    //"i.like.this.program.very.much"
    public static void main(String[] args) {
        ReverseWordsInStringInPlace reverseWordsInStringInPlace = new ReverseWordsInStringInPlace();
        String result = reverseWordsInStringInPlace.reverseWords("i.like.this.program.very.much");
        System.out.println(result);
    }

    public String reverseWords(String s) {

        int left = 0;
        int right = 0;

        char[] array = s.toCharArray();
        while (left < s.length() && right < s.length()) {
            if (s.charAt(right) == '.') {
                reverse(array, left, right - 1);
                left = right + 1;
                right = left;
            }
            right++;
        }
        reverse(array, left, right - 1);
        reverse(array, 0, s.length() - 1);


        return new String(array);
       /* StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }

        return sb.toString();*/

    }


    private void reverse(char[] ch, int start, int end) {

        int left = start;
        int right = end;

        while (left <= right) {
            char l = ch[left];
            char r = ch[right];

            ch[left] = r;
            ch[right] = l;

            left++;
            right--;

        }
    }
}
