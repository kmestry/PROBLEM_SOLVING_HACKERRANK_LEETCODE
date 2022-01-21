package com.datastructure_2_studyplan_leetcode.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list_0 = Arrays.asList(1);
        List<Integer> list_1 = Arrays.asList(1, 1);
        list.add(list_0);
        list.add(list_1);

        if (rowIndex <= 1) return list.get(rowIndex);

        int currRow = 2;
        int currElementsInList = 3;

        while (currRow <= rowIndex) {
            List<Integer> inList = new ArrayList<>();
            inList.add(1);

            int elementsToAdd = currElementsInList - 2;

            int indexL = 0;
            int indexR = 1;
            while (elementsToAdd > 0) {
                inList.add(list.get(currRow - 1).get(indexL) + list.get(currRow - 1).get(indexR));
                indexL++;
                indexR++;
                elementsToAdd--;
            }

            inList.add(1);
            list.add(inList);
            if (currRow == rowIndex) return list.get(rowIndex);

            currRow++;
            currElementsInList++;

        }
        return null;
    }
}
