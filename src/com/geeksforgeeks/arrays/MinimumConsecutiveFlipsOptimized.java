package com.geeksforgeeks.arrays;

public class MinimumConsecutiveFlipsOptimized {

    //Tricky and unique approach

    public static void main(String[] args) {
        MinimumConsecutiveFlipsOptimized minimumConsecutiveFlipsOptimized = new MinimumConsecutiveFlipsOptimized();
    /*     minimumConsecutiveFlipsOptimized.minimumConsecutiveFlips(new int[]{1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1});
        minimumConsecutiveFlipsOptimized.minimumConsecutiveFlips(new int[]{0, 1});
        minimumConsecutiveFlipsOptimized.minimumConsecutiveFlips(new int[]{1, 1});
        minimumConsecutiveFlipsOptimized.minimumConsecutiveFlips(new int[]{1, 1, 0, 0, 0, 1});*/
        minimumConsecutiveFlipsOptimized.minimumConsecutiveFlips(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 0, 1});
    }

    //group counts will be differ by one or
    //group counts will be same for 0 and 1 groups.
    //find the element which comes second in the traversal. and then
    //find that element and print the group range.
    private void minimumConsecutiveFlips(int[] array) {

        int element = -1;

        int rangeStart = -1;
        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] != array[i + 1]) {
                element = array[i + 1];
                rangeStart = i + 1;
                break;
            }
        }

        if (element != -1) {

            for (int i = rangeStart; i < array.length - 1; i++) {
                if (array[i] == element && rangeStart == -1) {
                    rangeStart = i;
                }
                if (array[i] == element && array[i] != array[i + 1]) {
                    System.out.println("From " + rangeStart + " to " + i);
                    rangeStart = -1;
                }

            }
            if (array.length == 2 && rangeStart == 1) {
                System.out.println("From " + rangeStart + " to " + (array.length - 1));
            }
            //corner case
            if (array[array.length - 1] == element && array[array.length - 1] != array[array.length - 2]) {
                System.out.println("From " + (array.length - 1) + " to " + (array.length - 1));
            }

        }

    }
}
