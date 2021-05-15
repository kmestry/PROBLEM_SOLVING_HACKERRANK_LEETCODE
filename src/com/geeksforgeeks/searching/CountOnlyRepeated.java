package com.geeksforgeeks.searching;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CountOnlyRepeated {

    public static Point findRepeating(Integer[] arr, int n) {
        //Your code here
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        Point p = new Point();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                p.x = entry.getKey();
                p.y = entry.getValue();
            }
        }

        return p;
    }
}
