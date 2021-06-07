package com.geeksforgeeks.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestProperPrefixSuffixArray {

    public static void main(String[] args) {
        LongestProperPrefixSuffixArray longestProperPrefixSuffixArray = new LongestProperPrefixSuffixArray();
        longestProperPrefixSuffixArray.constructLPSArray("ababab");
    }

    private int[] constructLPSArray(String input) {
        int[] result = new int[input.length()];
        result[0] = 0;

        List<String> properPrefixList = new ArrayList<>();
        List<String> suffixList = new ArrayList<>();

        int pointer1 = 0;
        int pointer2 = 1;

        //aba

        int arrayIndex = 1;
        while (pointer2 < input.length()) {
            String subString = input.substring(pointer1, pointer2 + 1); // end index is exclusive

            for (int i = 0; i <= subString.length() - 1; i++) {
                properPrefixList.add(subString.substring(0, i));
            }
            for (int i = subString.length() - 1; i >= 0; i--) {
                suffixList.add(subString.substring(i));
            }

            Set<String> commonStrings = properPrefixList.stream().filter(suffixList::contains).collect(Collectors.toSet());

            if (commonStrings.size() == 0) {
                result[arrayIndex] = 0;
            } else {
                int max = commonStrings.stream().map(String::length).max(Integer::compareTo).get();
                //  int max = list.stream().max(Integer::compareTo).get();
                result[arrayIndex] = max;
            }
            arrayIndex++;
            pointer2++;
            properPrefixList.clear();
            suffixList.clear();
        }

        return result;
    }
}
