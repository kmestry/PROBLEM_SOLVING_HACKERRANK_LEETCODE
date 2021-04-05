package com.geeksforgeeks.arrays;

public class StrongestNeighbour {

    public static void main(String[] args) {

        StrongestNeighbour.maximumAdjacent(6, new int[]{1, 2, 2, 3, 4, 5});
    }


    static void maximumAdjacent(int sizeOfArray, int[] arr) {

        /*********************************
         * Your code here
         * Function should print max adjacents for all pairs
         * Use string buffer for fast output
         * ***********************************/
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < arr.length; i++) {

            int max = Math.max(arr[i], arr[i - 1]);

            sb.append(max + " ");

        }


        String[] strings = sb.toString().split(" ");

        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}
