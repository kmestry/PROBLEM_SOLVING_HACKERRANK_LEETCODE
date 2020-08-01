package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicateNumber {
    public static void main(String[] args) {

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

}
