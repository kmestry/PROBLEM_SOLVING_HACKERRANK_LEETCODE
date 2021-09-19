package com.geeksforgeeks.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElements {

    public static void main(String[] args) {
        CountDistinctElements countDistinctElements = new CountDistinctElements();
        int count = countDistinctElements.countDistinctElements(new int[]{15, 12, 13, 12, 13, 13, 18});
        int count1 = countDistinctElements.countDistinctElements(new int[]{10,10,10});
        int count2 = countDistinctElements.countDistinctElements(new int[]{10,11,12});
        System.out.println(count);
        System.out.println(count1);
        System.out.println(count2);
    }

    int countDistinctElements(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int element : array) {
            map.merge(element, 1, Integer::sum);
        }

        return map.size();

    }
}
