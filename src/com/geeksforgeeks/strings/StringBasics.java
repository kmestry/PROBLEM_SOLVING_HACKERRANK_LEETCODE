package com.geeksforgeeks.strings;

public class StringBasics {

    public static void main(String[] args) {
        String s1 = "kun";

        String s2 = "kuz";


        int result = s1.compareTo(s2);

        if (result == 0) {
            System.out.println("both string are same");
        } else if (result > 0) {
            System.out.println("s1 is greater than s2");
        } else {
            System.out.println("s1 is smaller than s2");
        }
    }
}
