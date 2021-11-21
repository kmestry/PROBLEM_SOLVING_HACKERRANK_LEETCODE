package com.datastructure_studyplan_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            int a = nums1[i];
            int b = nums2[j];

            if (a == b) {
                result.add(a);
                i++;
                j++;
            } else if (a < b) {
                i++;
            } else {
                j++;
            }


        }

        int[] arr = new int[result.size()];

        int index = 0;
        for (Integer k : result) {
            arr[index++] = k;

        }
        return arr;

    }
}
