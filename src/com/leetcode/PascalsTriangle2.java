package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    public static void main(String[] args) {

        new PascalsTriangle2().getRow(3);
    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> firstList = new ArrayList<>();
        firstList.add(0);
        firstList.add(1);
        firstList.add(0);

        List<Integer> manipulationList = new ArrayList<>(firstList);
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            for (int j = 0; j < manipulationList.size() - 1; j++) {
                list.add(manipulationList.get(j) + manipulationList.get(j + 1));
            }
            list.add(0);
            manipulationList = new ArrayList<>(list);
        }


        manipulationList.remove(0);
        manipulationList.remove(manipulationList.size() - 1);
        return manipulationList;


    }
}
