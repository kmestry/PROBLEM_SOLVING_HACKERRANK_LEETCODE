package com.geeksforgeeks.searching;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

    /*    [4,5,6,0,0,0]
        3
                [1,2,3]
        3*/

        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        mergeTwoSortedArrays.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int left = m - 1;
        int right = n - 1;

        int index = nums1.length - 1;
        while (left >= 0 && right >= 0) {
            if (nums2[right] > nums1[left]) {
                nums1[index] = nums2[right];
                right--;
            } else {
                nums1[index] = nums1[left];
                left--;
            }
            index--;
        }

        while (left >= 0 && index >= 0) {
            nums1[index] = nums1[left];
            left--;
            index--;
        }
        while (right >= 0 && index >= 0) {
            nums1[index] = nums2[right];
            right--;
            index--;
        }
    }
}
