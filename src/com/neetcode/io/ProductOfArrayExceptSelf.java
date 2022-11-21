package com.neetcode.io;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().productExceptSelfOptimized(new int[]{1, 2, 3, 4});
    }

    public int[] productExceptSelf(int[] nums) {

        int[] prefixArr = new int[nums.length];
        int[] suffixArr = new int[nums.length];

        prefixArr[0] = nums[0];

        for (int i = 1; i < prefixArr.length; i++) {
            prefixArr[i] = prefixArr[i - 1] * nums[i];
        }

        suffixArr[nums.length - 1] = nums[nums.length - 1];

        for (int i = suffixArr.length - 2; i >= 0; i--) {
            suffixArr[i] = suffixArr[i + 1] * nums[i];
        }


        int[] res = new int[nums.length];

        res[0] = suffixArr[1];
        res[res.length - 1] = prefixArr[res.length - 2];
        for (int i = 1; i < res.length - 1; i++) {

            res[i] = prefixArr[i - 1] * suffixArr[i + 1];
        }

        return res;


    }

    public int[] productExceptSelfOptimized(int[] nums) {

        int[] res = new int[nums.length];

        int currProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = currProduct;
            currProduct *= nums[i];
        }

        currProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = currProduct * res[i];
            currProduct *= nums[i];
        }

        return res;
    }
}
