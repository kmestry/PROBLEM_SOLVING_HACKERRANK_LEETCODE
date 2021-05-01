package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSetUsingRecursion {

    public static void main(String[] args) {

        PowerSetUsingRecursion powerSetUsingRecursion = new PowerSetUsingRecursion();
        List<String> result = powerSet("abc");
        System.out.println("result = " + result);

    }

    static ArrayList<String> powerSet(String s) {
        // add your code here

        ArrayList<String> finalResult = new ArrayList<>();
        helper(s, new StringBuilder(), 0, finalResult);
        return finalResult;
    }


    //abc
    static void helper(String s, StringBuilder sb, int index, ArrayList<String> result) {
        // add your code here

        result.add(sb.toString());


        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            helper(s, sb, i + 1, result);
            sb.setLength(sb.length() - 1);

        }

    }

}
