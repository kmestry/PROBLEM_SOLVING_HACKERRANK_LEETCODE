package com.leetcode;

public class BurstBalloons {

    public static void main(String[] args) {
        new BurstBalloons().maxCoins(new int[]{3, 1, 5, 8});
    }

    public int maxCoins(int[] nums) {


        int result = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int length = nums.length;
        while (length > 0) {
            for (int i = 0; i < nums.length; i++) {

                if (nums[i] < 0) continue;


                int coins = 0;
                if (i == 0) {
                    if (nums.length == 1) {
                        coins = nums[i];
                    } else {
                        coins = nums[i] * nums[i + 1];
                    }

                } else if (i == nums.length - 1) {
                    coins = nums[i - 1] * nums[i];
                } else {
                    coins = nums[i] * nums[i - 1] * nums[i + 1];
                }


                if (coins > max) {
                    max = coins;
                    maxIndex = i;
                }
            }


            for (int i = maxIndex; i < nums.length - 1; i++) {
                int next = nums[i + 1];
                nums[i] = next;
            }


            result += max;
            length--;
            max = Integer.MIN_VALUE;
            maxIndex = -1;

            int[] numsCopy = new int[length];

            for (int i = 0; i < length; i++) {
                numsCopy[i] = nums[i];
            }

            nums = numsCopy;


        }

        return result;

    }
}
