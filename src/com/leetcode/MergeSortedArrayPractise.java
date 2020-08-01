package com.leetcode;

public class MergeSortedArrayPractise {


    public static void main(String[] args) {
        new MergeSortedArrayPractise().merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    //nums1 = [3,10,15,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //Output: [1,2,2,3,5,6]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1LastElementPointer = m - 1;
        int nums1EndPointer = nums1.length - 1;
        int nums2LastElementPointer = n - 1;

        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        while (nums1EndPointer > 0) {

            if (nums2LastElementPointer == -1 || nums1LastElementPointer == -1) {
                break;
            }
            if (nums2[nums2LastElementPointer] > nums1[nums1LastElementPointer]) {
                nums1[nums1EndPointer] = nums2[nums2LastElementPointer];
                nums2[nums2LastElementPointer] = 0;
                nums1EndPointer--;
                nums2LastElementPointer--;
            } else {
                nums1[nums1EndPointer] = nums1[nums1LastElementPointer];
                nums1[nums1LastElementPointer] = 0;
                nums1EndPointer--;
                nums1LastElementPointer--;
            }
        }

        if (nums1EndPointer >= 0) {
            if (nums2LastElementPointer >= 0) {
                for (int i = nums1EndPointer; i >= 0; i--) {
                    nums1[i] = nums2[nums2LastElementPointer];
                    nums2LastElementPointer--;
                    nums1EndPointer--;
                }
            } else if (nums1LastElementPointer >= 0) {
                for (int i = nums1EndPointer; i >= 0; i--) {
                    nums1[i] = nums1[nums1LastElementPointer];
                    nums1LastElementPointer--;
                    nums1EndPointer--;
                }
            }
        }

    }
}
