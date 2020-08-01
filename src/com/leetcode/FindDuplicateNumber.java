package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        //new FindDuplicateNumber().findDuplicateFloydTortoiseHareAlgo(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1});
        new FindDuplicateNumber().findDuplicateFloydTortoisePractise(new int[]{1, 3, 4, 2, 2});
    }

    public int findDuplicate(int[] nums) {

        Map<Integer, Integer> counterMap = new HashMap<>();

        for (int number : nums) {
            if (counterMap.containsKey(number)) {
                counterMap.put(number, counterMap.get(number) + 1);
            } else {
                counterMap.put(number, 1);
            }
        }
        Map.Entry<Integer, Integer> resultMap = counterMap.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue() > 1).findFirst().get();

        return resultMap.getKey();

    }

    public int findDuplicateOptimizedHashSet(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        int result = 0;
        for (int number : nums) {
            if (integers.contains(number)) {
                result = number;
                break;
            }
            integers.add(number);
        }
        return result;
    }

    //[1,3,4,2,2]
    public int findDuplicateFloydTortoiseHareAlgo(int[] nums) {
        //tortoise is slow pointer and hare is fast pointer.
        //tortoise moves 1 step hare 2 steps . the search is value based instead of index based.
        int tortoisePointer = 0;
        int harePointer = 0;

        do {
            harePointer = nums[nums[harePointer]];
            tortoisePointer = nums[tortoisePointer];

        } while (nums[harePointer] != nums[tortoisePointer]);
        tortoisePointer = 0;  // reset tortoise to start of array. now move both hare and tortoise 1 step.
        while (nums[harePointer] != nums[tortoisePointer]) {
            tortoisePointer = nums[tortoisePointer];
            harePointer = nums[harePointer];
        }

        return nums[harePointer];

    }

    public int findDuplicateFloydTortoisePractise(int[] nums) {
        int slowPointer = 0;
        int fastPointer = 0;

        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        } while (nums[slowPointer] != nums[fastPointer]);
        slowPointer = 0;
        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        } while (nums[slowPointer] != nums[fastPointer]);

        return nums[fastPointer];
    }

}
