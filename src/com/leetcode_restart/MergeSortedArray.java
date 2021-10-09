package com.leetcode_restart;

public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int elementPointer = nums1.length - 1;
            int nums2Right = nums2.length - 1;
            int nums1Right = m - 1;

            while (elementPointer >= 0 && nums1Right >= 0 && nums2Right >= 0) {
                if (nums2[nums2Right] > nums1[nums1Right]) {
                    nums1[elementPointer] = nums2[nums2Right];
                    nums2Right--;
                } else {
                    nums1[elementPointer] = nums1[nums1Right];
                    nums1Right--;
                }
                elementPointer--;
            }

            if (nums1Right >= 0 && elementPointer >= 0) {
                for (int i = elementPointer; i >= 0; i--) {
                    nums1[i] = nums1[nums1Right];
                    nums1Right--;
                }
            }
            if (nums2Right >= 0 && elementPointer >= 0) {
                for (int i = elementPointer; i >= 0; i--) {
                    nums1[i] = nums2[nums2Right];
                    nums2Right--;
                }
            }
        }

        // [2,0]
        // 1
        // [1]
        // 1

        // [0,0,0,0,0]
        // 0
        // [1,2,3,4,5]
        // 5
    }
}
