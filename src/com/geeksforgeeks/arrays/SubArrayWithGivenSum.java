package com.geeksforgeeks.arrays;

import java.util.ArrayList;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        //135 101 170 125 79 159 163 65 106 146 82 28 162 92 196 143 28 37 192 5 103 154 93 183 22 117 119 96 48 127 172 139 70 113 68 100 36 95 104 12 123 134
        //
        //Its Correct output is:
        //38 42
        //
        //And Your Code's output is:
        //-1 -1
        //
        //Test against custom input
        SubArrayWithGivenSum.subarraySum(new int[]{135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192
                , 5, 103,
                154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134}, 42, 468);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        // Your code here

        ArrayList<Integer> list = new ArrayList<>();

        int windowLeft = 0;
        int windowRight = 0;

        int currSum = 0;
        while (windowRight < arr.length || windowLeft < arr.length) {

            if (currSum == s) {
                list.add(windowLeft + 1);
                list.add(windowRight);
                return list;
            } else if (currSum < s && windowRight < arr.length) {

                currSum += arr[windowRight];
                windowRight++;
            } else {
                while (currSum > s && windowLeft < arr.length) {
                    currSum -= arr[windowLeft];
                    windowLeft++;
                }
            }

        }

        list.add(-1);
        list.add(-1);
        return list;


    }
}
