package com.datastructure_2_studyplan_leetcode.day7;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabelsUsingMergeIntervals {

    public static void main(String[] args) {
        PartitionLabelsUsingMergeIntervals partitionLabelsUsingMergeIntervals = new PartitionLabelsUsingMergeIntervals();
        //partitionLabelsUsingMergeIntervals.partitionLabels("eaaaabaaec");
        partitionLabelsUsingMergeIntervals.partitionLabels("dccccbaabe");
    }

    public List<Integer> partitionLabels(String s) {

        Map<Character, int[]> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                int[] arrFilled = map.get(c);
                arrFilled[1] = i;
                map.put(c, arrFilled);
            } else {
                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = i;
                map.put(c, arr);
            }
        }


        int min = map.get(s.charAt(0))[0];
        int max = map.get(s.charAt(0))[1];
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();

            int l = arr[0];
            int r = arr[1];
            if (l < max && r > max) {
                max = r;
            }
            if (l > max && r > max) {
                result.add(max - min + 1);
                min = l;
                max = r;
            }

        }
        result.add(max - min + 1);


        return result;
    }
}
