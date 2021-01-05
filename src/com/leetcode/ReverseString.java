package com.leetcode;//logic to reverse string : 
// use two pointers left and right,
// left pointer will point to start of string and right pointer will point to 
//end of string. swap left and right chars of the string.
// loop through the char array and append to result string to get the reversed string.
//


import java.util.HashSet;
import java.util.Set;

//Implement a logic to find the longest sequence of characters without repeating characters. For example, string "xyxyabcdefffxyze" so expected o/p is "abcdef".
public class ReverseString {

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        String result = obj.reverseString("kunal");

       /* String res = obj.longestSequenceWithoutRepeatingCharacters("abcabcbb");
        String res1 = obj.longestSequenceWithoutRepeatingCharacters("pwwkew");
        System.out.println("result = " + result);
        System.out.println("res = " + res);
        System.out.println("res1 = " + res1);*/

        //String result1 = obj.longestSequenceWithoutRepeatingCharacters("abcabcbb");
        String result1 = obj.longestSequenceWithoutRepeatingCharacters("dvdf");
    }


    public String reverseString(String input) {

        char[] chArray = input.toCharArray();

        int left = 0;
        int right = chArray.length - 1;

        while (left <= right) {
            char temp1 = chArray[left];
            char temp2 = chArray[right];
            chArray[right] = temp1;
            chArray[left] = temp2;

            left++;
            right--;

        }

        String result = "";

        for (int i = 0; i < chArray.length; i++) {
            result += chArray[i];
        }

        return result;
    }
//use two pointers to track the longest sequence .
//use a set of chars to check if the current sequence is having repeated chars.

// question i see the answer will be xyabcdef -- > longest sequence of characters without repeating characters ??
//Please correct if wrong.

    public String longestSequenceWithoutRepeatingCharacters(String input) {
        int length = input.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        String result = "";

        String formedString = "";
        while (right < length) {
            char ch = input.charAt(right);
            if (set.contains(ch)) {
                formedString = input.substring(left, right);
                if (formedString.length() > result.length()) {
                    result = formedString;

                }
                left++;
                right = left;
                formedString = "";
                set.clear();
                continue;
            } else {
                set.add(ch);
                formedString += ch;
            }

            right++;

        }

        if (formedString.length() > result.length()) {
            result = formedString;
        }

        return result;

    }
}




