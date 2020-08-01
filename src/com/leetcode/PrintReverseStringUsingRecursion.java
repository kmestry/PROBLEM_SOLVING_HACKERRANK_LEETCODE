package com.leetcode;

public class PrintReverseStringUsingRecursion {

    int index = 0;

    public static void main(String[] args) {
        new PrintReverseStringUsingRecursion().reverseStringRecursion(new char[]{'h', 'e', 'l', 'l', '0'});
    }

    //["h","e","l","l","o"]
    public void reverseString(char[] s) {
        int startPointer = 0;
        int endPointer = s.length - 1;

        while (startPointer <= endPointer) {
            char temp = s[startPointer];
            s[startPointer] = s[endPointer];
            s[endPointer] = temp;

            startPointer++;
            endPointer--;

        }
    }

    public void reverseStringRecursion(char[] s) {

        recurseArray(s, 0, s.length - 1);
    }

    public void recurseArray(char[] chars, int leftPointer, int rightPointer) {

        if (leftPointer > rightPointer) {
            return;
        }
        char temp = chars[leftPointer];
        chars[leftPointer] = chars[rightPointer];
        chars[rightPointer] = temp;
        recurseArray(chars, leftPointer + 1, rightPointer - 1);


    }


}
