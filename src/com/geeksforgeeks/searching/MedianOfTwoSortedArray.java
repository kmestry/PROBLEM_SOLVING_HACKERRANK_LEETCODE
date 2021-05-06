package com.geeksforgeeks.searching;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];

        int left = nums1.length - 1;
        int right = nums2.length - 1;
        int index = arr.length - 1;

        while (left >= 0 && right >= 0) {

            if (nums1[left] > nums2[right]) {
                arr[index] = nums1[left];
                left--;
            } else {
                arr[index] = nums2[right];
                right--;
            }
            index--;
        }

        while (left >= 0 && index >= 0) {
            arr[index] = nums1[left];
            left--;
            index--;
        }
        while (right >= 0 && index >= 0) {
            arr[index] = nums2[right];
            right--;
            index--;
        }
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        } else {
            double total = arr[arr.length / 2] + arr[arr.length / 2 - 1];
            return total / 2;
        }

    }
}
