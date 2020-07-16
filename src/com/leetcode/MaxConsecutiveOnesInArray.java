package com.leetcode;

public class MaxConsecutiveOnesInArray {

    public static void main(String[] args) {
        int result = new MaxConsecutiveOnesInArray().findMaxConsecutiveOnes(new int[]{0});
        System.out.println("result = " + result);
    }

    //[1,1,0,1,1,1]
    //1,0,1,1,0,1
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int maxConsecutiveOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                counter++;
            else {
                if (counter > maxConsecutiveOnes)
                    maxConsecutiveOnes = counter;
                counter = 0;
            }
        }
        return counter > maxConsecutiveOnes ? counter : maxConsecutiveOnes;
    }
}
