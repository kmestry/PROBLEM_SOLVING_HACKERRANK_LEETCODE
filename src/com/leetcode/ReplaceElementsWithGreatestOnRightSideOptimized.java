package com.leetcode;

public class ReplaceElementsWithGreatestOnRightSideOptimized {

    public static void main(String[] args) {

        int[] result = replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    //[17,18,5,4,6,1]
    public static int[] replaceElements(int[] arr) {

        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(arr[i], temp);
        }

        arr[arr.length - 1] = -1;

        return arr;

    }


}
