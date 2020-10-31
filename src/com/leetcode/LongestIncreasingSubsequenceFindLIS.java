package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequenceFindLIS {

    //https://www.youtube.com/watch?v=E6us4nmXTHs
    public static void main(String[] args) {
        new LongestIncreasingSubsequenceFindLIS().findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        /*new LongestIncreasingSubsequencePractise().
                findNumberOfLIS(new int[]{0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15});*/
    }


    public int findNumberOfLIS(int[] nums) {

        //[1,3,5,4,7]
        //0 0 1 0 3 3 5 6 3 6 8 9
        int[] length = new int[nums.length];
        int[] subsequence = new int[nums.length];
        Arrays.fill(length, 1); // smallest subsequence will be of length 1.

        int traverse = 0;
        int index = 1;

        while (index < nums.length) {
            while (traverse < index) {
                if (nums[traverse] < nums[index]) {

                    if (length[traverse] + 1 >= length[index]) {
                        length[index] = length[traverse] + 1;
                        subsequence[index] = traverse;
                    }


                }
                traverse++;
            }
            traverse = 0;
            index++;
        }

        int lis = Integer.MIN_VALUE;
        int indexOfLis = -1;
        for (int i = 0; i < length.length; i++) {
            if (length[i] > lis) {
                lis = length[i];
                indexOfLis = i;
            }
        }

        //find the LIS. BUILD LIS
        List<Integer> lisList = new ArrayList<>();
        while (indexOfLis != subsequence[indexOfLis]) {
            lisList.add(nums[indexOfLis]);
            indexOfLis = subsequence[indexOfLis];
        }
        for (int i = lisList.size() - 1; i >= 0; i--) {
            System.out.print(lisList.get(i) + " ");
        }
        //end Building LIS.

        return lis;

    }
}
