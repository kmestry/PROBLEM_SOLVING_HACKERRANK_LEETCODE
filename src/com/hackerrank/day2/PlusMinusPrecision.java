package com.hackerrank.day2;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class PlusMinusPrecision {

    //         6
    //        -4 3 -9 0 4 1
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int arraySize = arr.length;
        //initialize the map with zero count of each type of integers . i.e. Positive, Negative and Zero.
        Map<String, Integer> precisionMap = new HashMap();
        precisionMap.put("Negative", 0);
        precisionMap.put("Positive", 0);
        precisionMap.put("Zero", 0);

        for (int i = 0; i < arraySize; i++) {
            if (arr[i] < 0) {
                int negativeCount = precisionMap.get("Negative").intValue();
                negativeCount++;
                precisionMap.put("Negative", negativeCount);
            } else if (arr[i] == 0) {
                int zeroCount = precisionMap.get("Zero").intValue();
                zeroCount++;
                precisionMap.put("Zero", zeroCount);
            } else {
                int positiveCount = precisionMap.get("Positive").intValue();
                positiveCount++;
                precisionMap.put("Positive", positiveCount);
            }
        }

        DecimalFormat df = new DecimalFormat("0.000000");
        Float positiveValue = Float.valueOf(precisionMap.get("Positive")) / Float.valueOf(arraySize);
        Float negativeValue = Float.valueOf(precisionMap.get("Negative")) / Float.valueOf(arraySize);
        Float zeroValue = Float.valueOf(precisionMap.get("Zero")) / Float.valueOf(arraySize);
        System.out.println("positiveValue = " + df.format(positiveValue));
        System.out.println("negativeValue = " + df.format(negativeValue));
        System.out.println("df.format(zeroValue) = " + df.format(zeroValue));


    }

    public static void main(String[] args) {

        plusMinus(new int[]{-4, 3, -9, 0, 4, 1});

    }

}
