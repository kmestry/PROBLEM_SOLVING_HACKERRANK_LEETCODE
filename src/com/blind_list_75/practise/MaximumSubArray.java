package com.blind_list_75.practise;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int currSum = nums[0];  //-2
        int maxSum = currSum;   // -2

        for (int i = 1; i < nums.length; i++) {
            int continuousSum = nums[i] + currSum; // -1 , -2, 2 , 3, 5
            int currentNum = nums[i]; //1 , -3 , 4 , -1 , 2

            if (currentNum > continuousSum) {
                maxSum = Math.max(maxSum, currentNum); //max 1 , 4 , 5
                currSum = currentNum; // 1 , 4
            } else {
                currSum = continuousSum;  // -2 , 3
                maxSum = Math.max(maxSum, currSum); // 1 , 3
            }
        }
        return maxSum;
    }
}
