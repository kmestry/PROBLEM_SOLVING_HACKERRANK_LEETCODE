package com.leetcode;

public class FirstMissingPositiveOptimized {

    public static void main(String[] args) {
        new FirstMissingPositiveOptimized().firstMissingPositive(new int[]{7, 8, 9, 11, 12});
    }

    /*The basic idea is that we have an array with n cells (n is the length of the array). If an integer is
    missing it must be in the range [1..n]. This is the crucial observation we use to deduce the algorithm.
    This means that the range of possible answers is [1..n] if an integer is missing, and if an integer is not missing then the answer is n+1.

    I'll try my best to explain why.

    Let's picture the only two possibilities:

    there is no missing integer in the array
    there is a missing integer in the array.

    If there is no missing integer, this means that the array has all number from 1 to n. This must mean that
     the array is full. Why, because in the range [1..n] there are exactly n numbers, and if you place n numbers
     in an array of length n, the array is by definition full. (in this case solution is to return n+1 which is the first smallest integer).

    Once you understand the first case above understanding the second is easy. If there is a missing integer
    (or more than one), the missing integer(s), let's call it X, must be in the range 1..n. Why, because if the
    missing integer X is not in the range [1..n] that would imply that all integers [1..n] are in the array,
    which would mean that the array is full, leaving no space where to place X (since X is not in the range [1..n]).

    Then the algorithm becomes:

            1- Ignore all numbers <=0 and >n since they are outside the range of possible answers (which we proved was
            [1..n]). We do this by replacing them with the value n+1.
            2- For all other integers <n+1, mark their bucket (cell) to indicate the integer exists. (*see below)
            3- Find the first cell not marked, that is the first missing integer. If you did not find an unmarked cell,
             there was no missing integer, so return n+1.

            *I recommend looking at this solution for a very smart way to mark the cells:*/

    public int firstMissingPositive(int[] nums) {

        int length = nums.length;

        //mark negative and numbers greater than length of array to be positive
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= 0 || num > nums.length)
                nums[i] = length + 1;
        }


        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]);
            if (num > length) continue;
            num = num - 1; //zero indexed array
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
        }


        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }


        return length + 1;

    }
}
