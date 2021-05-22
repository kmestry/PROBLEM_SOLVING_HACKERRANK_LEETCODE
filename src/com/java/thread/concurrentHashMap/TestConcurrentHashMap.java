package com.java.thread.concurrentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();

        map.put("K", null);
        map.put("s", 23);
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }
    }
}
