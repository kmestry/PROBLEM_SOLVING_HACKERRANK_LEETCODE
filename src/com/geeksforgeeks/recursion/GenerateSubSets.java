package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubSets {

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {


        GenerateSubSets generateSubSets = new GenerateSubSets();
        List<String> list = new ArrayList<>();
        generateSubSets.generateSubSets("ABC", 0, list);
        System.out.println("result = " + result);
    }

    // ABC
    private void generateSubSets(String str, int index, List<String> list) {

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s);
        }
        result.add(sb.toString());

        if (list.size() > str.length()) {
            return;
        }


        for (int i = index; i < str.length(); i++) {
            list.add(String.valueOf(str.charAt(i)));
            generateSubSets(str, i + 1, list);
            list.remove(list.size() - 1);
        }


    }
}
