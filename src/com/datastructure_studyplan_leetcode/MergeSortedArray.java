package com.datastructure_studyplan_leetcode;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int filler = nums1.length - 1;

        int pointer1 = m - 1;
        int pointer2 = n - 1;

        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[filler] = nums1[pointer1];
                pointer1--;
            } else {
                nums1[filler] = nums2[pointer2];
                pointer2--;
            }
            filler--;
        }

        while (pointer1 >= 0) {
            nums1[filler] = nums1[pointer1];
            pointer1--;
            filler--;
        }

        while (pointer2 >= 0) {
            nums1[filler] = nums2[pointer2];
            pointer2--;
            filler--;
        }

    }
}
