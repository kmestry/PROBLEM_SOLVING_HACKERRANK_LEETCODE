package com.leetcode;

public class SortColors {

    //[2,0,2,1,1,0]
    public static void main(String[] args) {
        new SortColors().sortColorsDutchNationalFlagAlgorithm(new int[]{2, 0, 2, 1, 1, 0});
    }


    public void sortColors(int[] nums) {

        int[] countArray = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countArray[0] += 1;
            }
            if (nums[i] == 1) {
                countArray[1] += 1;
            }
            if (nums[i] == 2) {
                countArray[2] += 1;
            }

        }

        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            int counter = countArray[i];
            while (counter > 0) {
                nums[index] = i;
                index++;
                counter--;
            }
        }
    }

    public void sortColorsDutchNationalFlagAlgorithm(int[] nums) {

        int left = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
