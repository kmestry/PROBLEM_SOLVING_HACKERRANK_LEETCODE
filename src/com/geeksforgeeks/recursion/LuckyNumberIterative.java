package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberIterative {
    public static void main(String[] args) {

        boolean isLucky = LuckyNumberIterative.isLucky(85);
        System.out.println("isLucky = " + isLucky);
    }

    public static boolean isLucky(int n) {
        // Your code here

        List<Integer> list = new ArrayList<>(n + 1);
        list.add(0);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int indexToDeleteOuter = 2;

        int sizeAfterIteration = -1;
        while (list.contains(n)) {

            int initialSize = list.size();
            int indexToDeleteInner = indexToDeleteOuter;
            for (int i = 0; i < list.size() && indexToDeleteInner < list.size(); i++) {
                list.set(indexToDeleteInner, 0);
                indexToDeleteInner += indexToDeleteOuter;
            }
            List<Integer> result = new ArrayList<>();
            for (Integer integer : list) {
                if (integer > 0) {
                    result.add(integer);
                }
            }
            list = result;
            list.add(0, 0);
            sizeAfterIteration = list.size();

            if (initialSize == sizeAfterIteration) break;
            indexToDeleteOuter++;
        }

        return list.contains(n);
    }
}
