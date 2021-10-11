package com.leetcode_restart;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public @NotNull List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            int rowNum = i + 1;
            List<Integer> list = new ArrayList<>(rowNum);

            if (rowNum < 3) {
                for (int j = 0; j < rowNum; j++) {
                    list.add(1);
                }
            } else {
                List<Integer> previous = result.get(i - 1);
                list.add(1);

                for (int k = 0; k < previous.size() - 1; k++) {
                    list.add(previous.get(k) + previous.get(k + 1));
                }

                list.add(1);
            }

            result.add(list);
        }

        return result;

    }
}
