package com.leetcode;


//so the solution is calculate product, first from left to right, then from right to left;
// during the process we are guaranteed to encounter the max product; and whenever 0 is encountered, reset product to 1 and continue.
public class MaxProductSubArray {

    public static void main(String[] args) {
        new MaxProductSubArray().maxProductOptimized(new int[]{-2, 0, -1});
    }

    public int maxProduct(int[] nums) {

        if (nums.length == 1) return nums[0];

        int left = 0;
        int right = left + 1;

        int maxProduct = 0;
        while (left < nums.length) {
            int product = nums[left];
            if (product > maxProduct) maxProduct = product;
            while (right < nums.length) {
                product *= nums[right];
                right++;
                if (product > maxProduct) maxProduct = product;
            }
            left++;
            right = left + 1;
        }

        return maxProduct;
    }

    public int maxProductOptimized(int[] nums) {

        if (nums.length == 0) return 0;

        Integer maxProduct = Integer.MIN_VALUE;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];

            if (product > maxProduct) maxProduct = product;
            if (product == 0) product = 1;
        }

        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];

            if (product > maxProduct) maxProduct = product;
            if (product == 0) product = 1;
        }

        return maxProduct;

    }
}
