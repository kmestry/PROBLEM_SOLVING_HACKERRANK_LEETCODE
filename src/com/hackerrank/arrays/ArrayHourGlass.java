package com.hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ArrayHourGlass {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {


        System.out.println("arr.length = " + arr.length);
        int sum = 0;
        int rowCounter = 3;
        int columnCounter = 3;
        List<Integer> sumOfHourGlassList = new ArrayList<>();
        int secondRowIterationCounter = 0;
        int secondRowMiddleElement = 0;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                for (int k = i; k < rowCounter; k++) {
                    secondRowIterationCounter++;
                    for (int l = j; l < columnCounter; l++) {

                        if (secondRowIterationCounter == 2) {
                            secondRowMiddleElement++;
                        }
                        if (!(secondRowIterationCounter == 2 && (secondRowMiddleElement == 1 || secondRowMiddleElement == 3))) {
                            System.out.println(arr[k][l]);
                            sum += arr[k][l];
                        }
                    }
                }
                sumOfHourGlassList.add(sum);
                sum = 0;
                secondRowIterationCounter = 0;
                secondRowMiddleElement = 0;
                if (columnCounter == 6) {
                    columnCounter = 3;
                } else {
                    columnCounter++;
                }
            }
            rowCounter++;
        }
        System.out.println(sumOfHourGlassList);
        Optional<Integer> maxHourGlassSum = sumOfHourGlassList.stream().max(Integer::compareTo);
        System.out.println("maxHourGlassSUm = " + maxHourGlassSum);
        return maxHourGlassSum.get();
    }

    /*
    *   1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 2 4 4 0
        0 0 0 2 0 0
        0 0 1 2 4 0
    *
    * */

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

    }
}
