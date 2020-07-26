package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllNumbersDisappearedInArray {


    public static void main(String[] args) {
        new FindAllNumbersDisappearedInArray().findDisappearedNumbersOptimizedWithoutExtraSpace(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
    // [4,3,2,7,8,2,3,1]

    public List<Integer> findDisappearedNumbers(int[] nums) {

        //Arrays.sort(nums);
        List<Integer> result = IntStream.range(1, nums.length + 1).boxed().collect(Collectors.toList());
        List<Integer> inputList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        result.removeAll(inputList);

        return result;
    }

    public List<Integer> findDisappearedNumbersOptimized(int[] nums) {

        boolean[] stateArray = new boolean[nums.length + 1];

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            stateArray[nums[i]] = true;
        }
        for (int i = 1; i < stateArray.length; i++) {
            if (!stateArray[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbersOptimizedWithoutExtraSpace(int[] nums) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];

            if (nums[Math.abs(index) - 1] > 0)
                nums[Math.abs(index) - 1] = -1 * nums[Math.abs(index) - 1];

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
