package com.hackerrank.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTriplets {


    // Complete the compareTriplets function below.
    /*
    * 17 28 30 [alice]
       99 16 8 [bob]
       *
       * [2 1] [alice bob]
    * */

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();

        //initialize result of alice and bob to 0 and 0
        result.add(0, 0);
        result.add(1, 0);


        int innerLoopCounter = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = innerLoopCounter; j <= i; j++) {
                innerLoopCounter++;
                if (a.get(i) > b.get(j)) {
                    result.add(0, result.remove(0) + 1);
                }
                if (a.get(i) < b.get(j)) {
                    result.add(1, result.remove(1) + 1);
                }

            }
        }

        return result;

    }


    public static void main(String[] args) {
        compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8));


    }
}
