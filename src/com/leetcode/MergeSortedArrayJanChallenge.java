package com.leetcode;

public class MergeSortedArrayJanChallenge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1FillerPointer = nums1.length - 1;

        int nums1EndPointer = m - 1;
        int nums2EndPointer = n - 1;

        while (nums1EndPointer >= 0 && nums2EndPointer >= 0) {

            if (nums1[nums1EndPointer] > nums2[nums2EndPointer]) {
                nums1[nums1FillerPointer] = nums1[nums1EndPointer];
                nums1EndPointer--;
                nums1FillerPointer--;
            } else if (nums1[nums1EndPointer] < nums2[nums2EndPointer]) {
                nums1[nums1FillerPointer] = nums2[nums2EndPointer];
                nums2EndPointer--;
                nums1FillerPointer--;
            } else {
                nums1[nums1FillerPointer] = nums1[nums1EndPointer];
                nums1FillerPointer--;
                nums1[nums1FillerPointer] = nums2[nums2EndPointer];
                nums1FillerPointer--;

                nums1EndPointer--;
                nums2EndPointer--;
            }
        }

        if (nums1EndPointer >= 0) {
            while (nums1EndPointer >= 0 && nums1FillerPointer >= 0) {
                nums1[nums1FillerPointer] = nums1[nums1EndPointer];
                nums1EndPointer--;
                nums1FillerPointer--;
            }
        }

        if (nums2EndPointer >= 0) {
            while (nums2EndPointer >= 0 && nums1FillerPointer >= 0) {
                nums1[nums1FillerPointer] = nums2[nums2EndPointer];
                nums2EndPointer--;
                nums1FillerPointer--;
            }
        }


    }
}
