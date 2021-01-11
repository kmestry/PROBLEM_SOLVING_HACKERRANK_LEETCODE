package com.leetcode;

public class CreateSortedArrayThroughInstructionsBruteForce {

    public static void main(String[] args) {
        new CreateSortedArrayThroughInstructionsBinarySearch().createSortedArray(new int[]{1, 2, 3, 6, 5, 4});
    }

    public int createSortedArray(int[] instructions) {

        int cost = 0;

        for (int i = 1; i < instructions.length; i++) {
            int element = instructions[i];
            int strictlyLess = 0;
            int strictlyGreater = 0;
            //System.out.println( "element" + element);
            for (int j = 0; j < i; j++) {

                // System.out.println( "instructions[j]" + instructions[j]);
                if (instructions[j] == element) {
                    continue;
                } else if (instructions[j] > element) {
                    strictlyGreater++;
                } else {
                    strictlyLess++;
                }

            }
            cost += Math.min(strictlyLess, strictlyGreater);
        }

        return cost;
    }
}
