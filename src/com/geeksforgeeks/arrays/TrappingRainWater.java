package com.geeksforgeeks.arrays;

public class TrappingRainWater {

    public static void main(String[] args) {

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int result = trappingRainWater.getWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("result = " + result);
    }

    // no water can be stored in leftmost and rightmost bars.
    //Logic : find lmax and rmax for every element. water stored at that position
    //is equal to min(lmax,rmax) - element

    //TLE approach
    private int getWater(int[] array) {

        int waterStored = 0;

        for (int i = 1; i < array.length - 1; i++) {

            int element = array[i];

            int lmax = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                if (array[j] > lmax) {
                    lmax = array[j];
                }
            }

            int rMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > rMax) {
                    rMax = array[j];
                }
            }

            int waterAtPosition = Math.min(lmax, rMax) - element;
            // we do not consider negative waterAtPosition, hence adding 0;
            waterStored += Math.max(waterAtPosition, 0);
        }

        return waterStored;
    }
}
