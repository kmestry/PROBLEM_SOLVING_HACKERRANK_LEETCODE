package com.leetcode;

public class ReversePairs {

    public static void main(String[] args) {
        new ReversePairs().reversePairs(new int[]{1, 3, 2, 3, 1});
    }


    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergesort(nums, 0, nums.length - 1);
    }

    private int mergesort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = mergesort(nums, low, mid) + mergesort(nums, mid + 1, high);
        for (int i = low, j = mid + 1; i <= mid && j <= high; ) {
            if (nums[i] > (long) nums[j] * 2) {
                count += mid - i + 1;
                j++;
            } else i++;
        }

        merge(nums, low, high);
        return count;
    }

    private void merge(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        int[] arr = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;
        while (k < arr.length) {
            int num1 = i > mid ? Integer.MAX_VALUE : nums[i];
            int num2 = j > high ? Integer.MAX_VALUE : nums[j];

            arr[k++] = num1 <= num2 ? nums[i++] : nums[j++];
        }

        for (int p = 0; p < arr.length; p++) {
            nums[p + low] = arr[p];
        }
    }

}
