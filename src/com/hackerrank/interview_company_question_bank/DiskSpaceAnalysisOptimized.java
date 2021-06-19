package com.hackerrank.interview_company_question_bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DiskSpaceAnalysisOptimized {

    public static void main(String[] args) {
        int result = DiskSpaceAnalysisOptimized.segment(3, Arrays.asList(2, 5, 4, 6, 8));
        System.out.println(result);
    }

    public static int segment(int x, List<Integer> space) {
        int pointer1 = 0;
        int pointer2 = x;

        List<Integer> comboList = new ArrayList<>();
        List<Integer> windowList = new ArrayList<>();
        for (int i = pointer1; i < pointer2; i++) {
            windowList.add(space.get(i));
        }
        comboList.add(findMin(windowList).orElse(null));
        while (pointer2 < space.size()) {
            windowList.remove(space.get(pointer1));
            windowList.add(space.get(pointer2));
            comboList.add(findMin(windowList).orElse(null));
            pointer1++;
            pointer2++;
        }

        return findMax(comboList).orElse(Integer.MAX_VALUE);
    }

    private static Optional<Integer> findMin(List<Integer> list) {
        return list.stream().min(Integer::compareTo);
    }

    private static Optional<Integer> findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo);
    }
}
