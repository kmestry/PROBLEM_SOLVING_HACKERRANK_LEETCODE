package com.hackerrank.interview_companies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShoppersDelightEfficient {

    public static void main(String[] args) {

        ShoppersDelightEfficient shoppersDelightEfficient = new ShoppersDelightEfficient();
        long result = shoppersDelightEfficient.getNumberOfOptions(Arrays.asList(7, 8, 9, 1, 8, 6, 14), Arrays.asList(10, 5, 7), Arrays.asList(5, 6, 6, 4, 8, 8)
                , Arrays.asList(3, 12, 11, 3), 30);
        System.out.println(result);

        //314 expected
    }

    public long
    getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes,
                       List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {

        List<Integer> comboList1 = new ArrayList<>();

        for (Integer i : priceOfJeans) {
            for (Integer j : priceOfShoes) {
                comboList1.add(i + j);
            }
        }


        List<Integer> comboList2 = new ArrayList<>();

        for (Integer i : priceOfTops) {
            for (Integer j : priceOfSkirts) {
                comboList2.add(i + j);
            }
        }

        comboList1.sort(Integer::compareTo);

        comboList2.sort(Collections.reverseOrder());


        int indexCombo2List = 0;
        long counter = 0;
        for (int i = 0; i < comboList1.size(); i++) {
            while (indexCombo2List < comboList2.size()) {
                if (comboList1.get(i) + comboList2.get(indexCombo2List) <= budgeted) {
                    counter += comboList2.size() - indexCombo2List;
                    //indexCombo2List++;
                    break;
                } else {
                    indexCombo2List++;
                }
            }
        }

        return counter;


    }
}
