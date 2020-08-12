package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        new PascalsTriangle().generate(3);
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        resultList.add(firstList);


        for (int i = 1; i < numRows; i++) {

            List<Integer> list = resultList.get(resultList.size() - 1);//get last index

            List<Integer> manipulationList = new ArrayList<>(list);
            manipulationList.add(0);
            manipulationList.add(0, 0);

            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < manipulationList.size() - 1; j++) {
                int element = manipulationList.get(j) + manipulationList.get(j + 1);
                innerList.add(element);
            }

            resultList.add(innerList);

        }

        return resultList;
    }
}
