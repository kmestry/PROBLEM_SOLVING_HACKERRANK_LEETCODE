package com.hackerrank.morgan;

import java.util.*;

public class ArrayListDuplicates {
    public static void main(String[] args) {
        ArrayListDuplicates arrayListDuplicates = new ArrayListDuplicates();
        arrayListDuplicates.printDuplicates(Arrays.asList(1, 1, 1, 2, 3, 4, 2));
    }

    private void printDuplicates(List<Integer> list) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            int element = list.get(i);

            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("duplicate is " + entry.getKey());
            }
        }
    }

    private void printDuplicatesSet(List<Integer> list) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> printSet = new HashSet<>();
        for (Integer i : list) {
            if (set.contains(i)) {
                printSet.add(i);
            } else {
                set.add(i);
            }
        }
        for (Integer i : printSet) {
            System.out.println("DUplicate :" + i);
        }

    }
}
