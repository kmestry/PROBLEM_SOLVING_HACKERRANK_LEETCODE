package com.blind_list_75.array;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int product = 1;
        int zeroCount = 0;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            }
            product *= nums[i];
        }
        // System.out.println(zeroCount);
        if (zeroCount >= 1 && product == 0) {

            int productInner = 1;

            for (int i = 0; i < nums.length; i++) {
                if (zeroIndex == i) continue;
                productInner *= nums[i];
            }
            result[zeroIndex] = productInner;

            return result;

        }


        for (int i = 0; i < nums.length; i++) {
            result[i] = product / nums[i];
        }
        return result;
    }
}
