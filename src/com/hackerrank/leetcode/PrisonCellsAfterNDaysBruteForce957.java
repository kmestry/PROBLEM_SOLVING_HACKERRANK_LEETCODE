package com.hackerrank.leetcode;

public class PrisonCellsAfterNDaysBruteForce957 {


    public static int[] prisonAfterNDays(int[] cells, int N) {


        int[] result = new int[cells.length];


        //repetition occurs after every 14th transformation.
        for (int i = 0; i < N; i++) {

            for (int j = 1; j < cells.length - 1; j++) {

                result[j] = (cells[j - 1] ^ cells[j + 1]) ^ 1; // anything xor with itself will flip the bit. i.e. 0 to 1 . 1 to 0.

            }
            System.arraycopy(result, 0, cells, 0, cells.length);


        }


        return result;

    }

    public static void main(String[] args) {

        //[1,0,0,1,0,0,1,0]
        //1000000000

        int[] result = prisonAfterNDays(new int[]{0, 0, 0, 1, 1, 0, 1, 0}, 574);

        System.out.println("final");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");

        }
    }
}
