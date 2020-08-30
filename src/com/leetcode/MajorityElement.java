package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {


    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

        }

        int size = nums.length / 2;
        int result = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > size) {
                result = key;
                break;
            }
        }

        return result;

    }


    public int majorityElementMooreAlgo(int[] nums) {

        //bayer moore's voting algo
        int candidate = 0;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {

            if (counter == 0) {
                candidate = nums[i];
                counter++;
            } else {
                if (candidate == nums[i]) {
                    counter++;
                } else {
                    counter--;
                }

            }

        }


        return candidate;

    }
}
