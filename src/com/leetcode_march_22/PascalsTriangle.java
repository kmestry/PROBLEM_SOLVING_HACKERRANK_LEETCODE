package com.leetcode_march_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public List<Integer> getRow(int rowIndex) {

        if (rowIndex == 0) return List.of(1);
        if (rowIndex == 1) return Arrays.asList(1, 1);

        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        list.add(Arrays.asList(1, 1));

        int currRow = 2;
        while (currRow <= rowIndex) {

            List<Integer> inList = new ArrayList<>();
            inList.add(1);

            int index = 0;
            for (int i = 0; i < currRow - 1; i++) {
                inList.add(list.get(currRow - 1).get(index) + list.get(currRow - 1).get(index + 1));
                index++;
            }

            inList.add(1);

            list.add(inList);

            currRow++;
        }
        // System.out.println(list);
        return list.get(rowIndex);

    }
}
