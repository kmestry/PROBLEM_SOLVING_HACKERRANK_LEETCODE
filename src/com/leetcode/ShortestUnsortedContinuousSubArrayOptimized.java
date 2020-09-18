package com.leetcode;

public class ShortestUnsortedContinuousSubArrayOptimized {

    public static void main(String[] args) {

        new ShortestUnsortedContinuousSubArrayOptimized().findUnsortedSubarray(new int[]{1, 3, 2, 2, 2
        });
    }

    // 2 6 4 8 10 9 15


    public int findUnsortedSubarray(int[] nums) {

        int startIndex = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                startIndex = i;
                break;
            }
        }

        if (startIndex == -1) return 0; //early break as array is already sorted.
        int endIndex = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i - 1] > nums[i]) {
                endIndex = i;
                break;
            }
        }

        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {

            minElement = Math.min(nums[i], minElement);
            maxElement = Math.max(nums[i], maxElement);

        }

        int minIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (minElement < nums[i]) {
                minIndex = i;
                break;
            }
        }

        int maxIndex = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxElement > nums[i]) {
                maxIndex = i;
                break;
            }
        }


        return maxIndex - minIndex + 1;


    }
}

