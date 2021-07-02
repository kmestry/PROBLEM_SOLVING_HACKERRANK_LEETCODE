package com.blind_list_75.array;

public class ProductOfArrayExceptSelfOptimized {

    public static void main(String[] args) {
        ProductOfArrayExceptSelfOptimized product = new ProductOfArrayExceptSelfOptimized();
        product.productExceptSelf(new int[]{1, 2, 3, 4});
    }

    public int[] productExceptSelf(int[] nums) {
        // 1 2 3 4
        //  24  24  12  4
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        right[right.length - 1] = nums[nums.length - 1];

        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }

        // product of an element = product of left * product of right
        // eg : 3 == 1*2 * 4;

        result[0] = right[1];
        result[result.length - 1] = left[result.length - 2];
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = left[i - 1] * right[i + 1];
        }

        return result;
    }
}
