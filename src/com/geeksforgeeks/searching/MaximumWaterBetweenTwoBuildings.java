package com.geeksforgeeks.searching;

public class MaximumWaterBetweenTwoBuildings {


    //16 11 16 62 2 97 61 1 66 32 58 48 17 5 93 3 83 91 84 14 5 52 58 26 37 36 81 55 55 40 65 24 97 98 75 88 97 29 45 36 77 40 26 13 84 90 89 91 43 41 51 66 86 63 96 92 8 60 77 99 60 90 59 48 30 49

    public static void main(String[] args) {
        int[] arr = new int[]{16, 11, 16, 62, 2, 97, 61, 1, 66, 32, 58, 48, 17, 5, 93, 3, 83, 91, 84, 14, 5, 52, 58, 26, 37, 36, 81, 55, 55, 40, 65, 24, 97, 98, 75, 88, 97, 29, 45, 36, 77, 40, 26, 13, 84, 90, 89, 91, 43, 41, 51, 66, 86, 63, 96, 92, 8, 60, 77, 99, 60, 90, 59, 48, 30, 49};
        int water = MaximumWaterBetweenTwoBuildings.maxWater(arr, 66);
        System.out.println("water = " + water);
    }

    static int maxWater(int[] height, int n) {
        //Your code here
        int i = 0;
        int j = n - 1;
        int maxWater = 0;
        while (i < j) {
            maxWater = Math.max(maxWater, Math.min(height[i], height[j]) * (j - i - 1));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}
