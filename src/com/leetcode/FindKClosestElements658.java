package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements658 {

    //[1,2,3,4,5], k = 4, x = -1
    public static void main(String[] args) {
        List<Integer> resultList = findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        System.out.println("resultList = " + resultList);
    }

    public static int findFirstPositionOfTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        if (target < array[0])
            return -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target > array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[left] == target) return left;
        if (array[right] == target) return right;
        return -1;
    }

    public static int findLastPositionOfTargetBinarySearch(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target)
            return 0;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && nums[mid] == nums[mid + 1] && mid + 1 == nums.length - 1)
                return mid + 1;
            if (nums[mid] == target && nums[mid] != nums[mid + 1]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (nums[nums.length - 1] == target) return nums.length - 1;
        return 0;
    }


    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int counter = 0;
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            if (counter == k)
                break;
            int firstPositionOfTarget = findFirstPositionOfTarget(arr, x - i);
            int lastPositionOfTarget = 0;
            if (firstPositionOfTarget != -1) {
                lastPositionOfTarget = findLastPositionOfTargetBinarySearch(Arrays.copyOfRange(arr, firstPositionOfTarget, arr.length), x - i);
                if (lastPositionOfTarget != -1) {
                    for (int j = firstPositionOfTarget; j <= lastPositionOfTarget + firstPositionOfTarget; j++) {
                        resultList.add(arr[j]);
                        counter++;
                        if (counter == k)
                            break;
                    }
                }
            }

            if (counter == k)
                break;

            if (!resultList.contains(x + i)) {
                int firstPositionOfTargetPositive = findFirstPositionOfTarget(arr, x + i);
                int lastPositionOfTargetPositive = 0;
                if (firstPositionOfTargetPositive != -1) {
                    lastPositionOfTargetPositive = findLastPositionOfTargetBinarySearch(Arrays.copyOfRange(arr, firstPositionOfTargetPositive, arr.length), x + i);
                    if (lastPositionOfTargetPositive != -1) {
                        for (int j = firstPositionOfTargetPositive; j <= lastPositionOfTargetPositive + firstPositionOfTargetPositive; j++) {
                            resultList.add(arr[j]);
                            counter++;
                            if (counter == k)
                                break;
                        }
                    }
                }

                if (counter == k)
                    break;

            }
          /*  if (counter == k)
                break;*/

        }
        Collections.sort(resultList);
        return resultList;


    }
}
