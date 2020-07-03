package com.hackerrank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrisonCellsAfterNDays957 {


    public static int[] prisonAfterNDays(int[] cells, int N) {


        int[] result = new int[cells.length];

        List<List<Integer>> list = new ArrayList<>();
        int length = N > 14 ? 14 : N;
        //repetition occurs after every 14th transformation.
        for (int i = 0; i < length; i++) {

            for (int j = 1; j < cells.length - 1; j++) {

                result[j] = (cells[j - 1] ^ cells[j + 1]) ^ 1; // anything xor with itself will flip the bit. i.e. 0 to 1 . 1 to 0.

            }
            System.arraycopy(result, 0, cells, 0, cells.length);
            list.add(Arrays.stream(result).boxed().collect(Collectors.toList()));
        }

        int indexOfResult = 0;
        if (N > 14) {
            indexOfResult = N % 14;
        } else {
            indexOfResult = list.size();
        }
        indexOfResult = indexOfResult == 0 ? 14 : indexOfResult;
        result = list.get(indexOfResult - 1).stream().mapToInt(value -> value).toArray();

        return result;

    }

    public static void main(String[] args) {

        //[1,0,0,1,0,0,1,0]
        //1000000000

        //[0,0,0,1,1,0,1,0]
        //574
        int[] result = prisonAfterNDays(new int[]{0, 0, 0, 1, 1, 0, 1, 0}, 574);

        System.out.println("final");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");

        }
    }
}
