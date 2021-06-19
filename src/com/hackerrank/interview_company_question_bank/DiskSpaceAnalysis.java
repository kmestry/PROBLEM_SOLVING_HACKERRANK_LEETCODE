package com.hackerrank.interview_company_question_bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiskSpaceAnalysis {
    public static void main(String[] args) {
        int result = DiskSpaceAnalysis.segment(3, Arrays.asList(2, 5, 4, 6, 8));
        System.out.println(result);
    }

    // 1,2,4,5

    // {8 , 2, 4, 6} , 2 segments
    // [8,2] [2,4] [4,6]
    // [2,2,4] , max of this is 4
    public static int segment(int x, List<Integer> space) {
        // Write your code here

        List<Integer> comboList = new ArrayList<>();

        int pointer1 = 0;
        int pointer2 = x;

        while (pointer2 <= space.size()) {

            int windowMin = Integer.MAX_VALUE;
            for (int i = pointer1; i < pointer2; i++) {
                windowMin = Math.min(windowMin, space.get(i));
            }
            comboList.add(windowMin);
            pointer1++;
            pointer2++;
        }

        return findMax(comboList);

    }


    private static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo).get();
    }
}
