package com.leetcode;

public class MergeSortedArray {

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{4, 0, 0, 0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
    }

   /* nums1 = [1,2,3,0,0,0], m = 3
      nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]*/

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1LastElementPointer = m - 1;
        int nums1EndPointer = nums1.length - 1;
        int nums2EndPointer = nums2.length - 1;

        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        } else {


            while (nums1LastElementPointer >= 0 || nums1EndPointer >= 0 || nums2EndPointer >= 0) {
                if (nums1EndPointer < 0 || nums2EndPointer < 0) break;

                if (nums1LastElementPointer < 0 && nums2EndPointer >= 0) {
                    for (int i = 0; i <= nums2EndPointer; i++) {
                        nums1[i] = nums2[i];

                    }
                    nums2EndPointer = -1;
                } else if (nums1[nums1LastElementPointer] < nums2[nums2EndPointer]) {
                    nums1[nums1EndPointer] = nums2[nums2EndPointer];
                    nums1EndPointer--;
                    nums2EndPointer--;
                } else {
                    nums1[nums1EndPointer] = nums1[nums1LastElementPointer];
                    nums1[nums1LastElementPointer] = 0;
                    nums1LastElementPointer--;
                    nums1EndPointer--;

                }
            }
        }
    }
}
