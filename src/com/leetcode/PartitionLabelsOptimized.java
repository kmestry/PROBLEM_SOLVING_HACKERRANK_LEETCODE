package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabelsOptimized {

    public static void main(String[] args) {
        List<Integer> list = new PartitionLabelsOptimized().partitionLabels("eaaaabaaec"

        );
        System.out.println("list = " + list);
    }

    public List<Integer> partitionLabels(String inputString) {

        int[] lastIndices = new int[26];
        for (int i = 0; i < inputString.length(); i++) {
            lastIndices[inputString.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            end = Math.max(lastIndices[inputString.charAt(i) - 'a'], end);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }

        return list;
    }

}
