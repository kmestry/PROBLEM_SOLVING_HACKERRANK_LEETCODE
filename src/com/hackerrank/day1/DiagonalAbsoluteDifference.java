package com.hackerrank.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int listLength = arr.size();
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        if (listLength == 1)
            return arr.get(0).get(0);

        for (int i = 0; i < listLength; i++) {
            primaryDiagonalSum += arr.get(i).get(i);

        }

        for (int j = 0; j < listLength; j++) {
            secondaryDiagonalSum += arr.get(j).get((listLength - 1) - j);
        }

        if ((primaryDiagonalSum - secondaryDiagonalSum) < 0)
            return -(primaryDiagonalSum - secondaryDiagonalSum);

        else
            return primaryDiagonalSum - secondaryDiagonalSum;
    }

}

public class DiagonalAbsoluteDifference {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(0, Arrays.asList(11, 2));
        arr.add(1, Arrays.asList(1, 5));
        /*arr.add(1, Arrays.asList(4, 5, 6));
        arr.add(2, Arrays.asList(10, 8, -12));*/
        int result = Result.diagonalDifference(arr);
        System.out.println("result = " + result);


    }
}
