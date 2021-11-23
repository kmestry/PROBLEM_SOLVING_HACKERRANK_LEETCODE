package com.datastructure_studyplan_leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        if (numRows == 1) {

            List<List<Integer>> result = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            first.add(1);
            result.add(first);
            return result;
        }


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        result.add(second);

        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            int index = 0;
            int counter = i - 1;
            while (counter > 0) {
                List<Integer> prevList = result.get(i - 1);
                list.add(prevList.get(index) + prevList.get(index + 1));
                counter--;
                index++;
            }
            list.add(1);
            result.add(list);

        }

        return result;

    }
}

