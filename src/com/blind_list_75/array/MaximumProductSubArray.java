package com.blind_list_75.array;

public class MaximumProductSubArray {


    /*   Here is my explanation for future readers-

       Simplest case. Consider this array [1,2,3,-4,5,6]. We can think of -4 as dividing the array into 2
       halves, [1,2,3] and [5,6]. The forward traversal yields
       the max as 6, while the reverse traversal yields 30.
       Say the array has even number of negative numbers eg. [1,2,-3,-4,5,6]. Both forward and
       reverse traversals yield the same result, so it doesnt matter.
       Say the array has multiple odd number of negative integers. eg. [1,2,-3,-4,-5, 6].
       We can think of the "last" negative number in each traversal breaks the array to 2 halves. In this case ,
       the max
       array in forward traversal is the maximum of ([1,2,-3,-4] and [6]) which is 24. In the reverse,
       the split is delimited by -3. So the max subarrray is teh maximum of ([6,-5,-4] and [2])
       Hence, in the end, its all about the presence of odd or even number of negative integers.
       In case of even, the product is always positive. In case of odd, the max product is limited by the last
       negative integer in each traversal.
     */
    public int maxProduct(int[] nums) {

        //3,-1,4
        // -3, -1 , -1

        int maxProduct = Integer.MIN_VALUE;
        int currProduct = 1;
        for (int num : nums) {
            currProduct *= num;
            maxProduct = Math.max(maxProduct, currProduct);

            if (currProduct == 0) {
                currProduct = 1;
            }
        }

        currProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            currProduct *= nums[i];
            maxProduct = Math.max(maxProduct, currProduct);

            if (currProduct == 0) {
                currProduct = 1;
            }
        }

        return maxProduct;
    }
}
