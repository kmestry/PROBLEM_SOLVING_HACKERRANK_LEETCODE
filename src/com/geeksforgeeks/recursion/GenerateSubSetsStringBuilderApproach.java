package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubSetsStringBuilderApproach {

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {


        GenerateSubSetsStringBuilderApproach generateSubSets = new GenerateSubSetsStringBuilderApproach();
        generateSubSets.generateSubSets("abcd", 0, new StringBuilder());
        System.out.println("result = " + result);
    }

    // ABC
    private void generateSubSets(String str, int index, StringBuilder sb) {


        result.add(sb.toString());

        if (sb.length() > str.length()) {
            return;
        }


        for (int i = index; i < str.length(); i++) {
            sb.append(str.charAt(i));
            generateSubSets(str, i + 1, sb);
            sb.setLength(sb.length() - 1);
        }


    }
}
