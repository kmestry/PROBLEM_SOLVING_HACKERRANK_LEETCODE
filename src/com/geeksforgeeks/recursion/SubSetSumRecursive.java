package com.geeksforgeeks.recursion;

public class SubSetSumRecursive {

    public static void main(String[] args) {

        SubSetSumRecursive subSetSumRecursive = new SubSetSumRecursive();
        int result = subSetSumRecursive.helper(new int[]{10, 20, 15}, 0, 0);
        System.out.println("result = " + result);
    }

    private int helper(int[] array, int sum, int index) {

        if (index == array.length) return sum == 0 ? 1 : 0;


        return helper(array, sum, index + 1)
                + helper(array, sum - array[index], index + 1);

    }
}
