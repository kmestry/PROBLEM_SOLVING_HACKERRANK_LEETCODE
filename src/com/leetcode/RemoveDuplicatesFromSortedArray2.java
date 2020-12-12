package com.leetcode;

public class RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedArray2().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    }

    public int removeDuplicates(int[] nums) {
        int result = nums.length;

        int i = 1;
        //1,1,1,2,2,3
        //0,0,1,1,1,1,2,3,3
        int count = 1;
        while (i < result) {


            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    result -= 1;
                    int temp = nums[i];

                    for (int j = i; j < nums.length - 1; j++) {
                        int temp2 = nums[j + 1];

                        nums[j] = temp2;
                    }
                    nums[nums.length - 1] = temp;
                    i = i - 1;
                }
            } else if (nums[i] != nums[i - 1]) {
                count = 1;
            }

            i++;
        }
        // System.out.println(result);

        return result;
    }
}
