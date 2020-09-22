package com.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTreeMapApproach {


    TreeMap tm;

    public MyCalendarTreeMapApproach() {
        tm = new TreeMap<Integer, Integer>();
    }

    public static void main(String[] args) {
        MyCalendarTreeMapApproach calendar = new MyCalendarTreeMapApproach();

       /* boolean r = calendar.book(37, 50);
        boolean r1 = calendar.book(33, 50);
        System.out.println("r = " + r);
        System.out.println("r1 = " + r1);*/

        calendar.book(47, 50);
        calendar.book(33, 41);
        calendar.book(39, 45);
        calendar.book(33, 42);
        calendar.book(25, 32);
        calendar.book(26, 35);
        calendar.book(19, 25);
        calendar.book(3, 8);
        calendar.book(8, 13);
        calendar.book(18, 27);
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = tm.lowerEntry(end);
        if (entry != null && entry.getValue() > start) return false;
        tm.put(start, end);
        return true;
    }
}
