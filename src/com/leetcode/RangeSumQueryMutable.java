package com.leetcode;

public class RangeSumQueryMutable {

    class NumArray {

        int[] array;
        int[] origArray;

        public NumArray(int[] nums) {
            this.origArray = new int[nums.length];
            System.arraycopy(nums, 0, origArray, 0, origArray.length);
            this.array = nums;
            init(array);


        }

        private void init(int[] array) {
            //prefix sum
            for (int i = 1; i < array.length; i++) {
                array[i] = array[i] + array[i - 1];
            }
        }

        public void update(int i, int val) {

            int previousVal = origArray[i];
            int newVal = val;
            origArray[i] = newVal;
            int diff = Math.abs(newVal - previousVal);

            //stem.out.println(previousVal);
            //System.out.println(newVal);

            if (newVal > previousVal) {
                for (int j = i; j < array.length; j++) {
                    array[j] = array[j] + diff;
                }
            } else {
                for (int j = i; j < array.length; j++) {
                    array[j] = array[j] - diff;
                }
            }

        }

        public int sumRange(int i, int j) {

            int lower;

            if (i - 1 < 0) {
                lower = 0;
            } else {
                lower = array[i - 1];
            }


            return array[j] - lower;

        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
