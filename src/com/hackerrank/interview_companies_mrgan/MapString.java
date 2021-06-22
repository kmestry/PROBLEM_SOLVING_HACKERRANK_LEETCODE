package com.hackerrank.interview_companies_mrgan;

import java.util.HashMap;
import java.util.Map;

public class MapString {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();

        String a = "abc";
        String b = "abc";
        m.put(a, 10);
        m.put(b, 20);
        m.put("abc", 30);
        System.out.println(m.get("abc"));
    }
}
