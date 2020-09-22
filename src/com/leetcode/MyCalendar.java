package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCalendar {

    List<Interval> list = new ArrayList<>();

    public MyCalendar() {

    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();

        boolean r = calendar.book(37, 50);
        boolean r1 = calendar.book(33, 50);
        System.out.println("r = " + r);
        System.out.println("r1 = " + r1);

        /*calendar.book(47, 50);
        calendar.book(33, 41);
        calendar.book(39, 45);
        calendar.book(33, 42);
        calendar.book(25, 32);
        calendar.book(26, 35);
        calendar.book(19, 25);
        calendar.book(3, 8);
        calendar.book(8, 13);
        calendar.book(18, 27);*/
    }

    public boolean book(int start, int end) {

        if (list.isEmpty()) {
            list.add(new Interval(start, end));
            return true;

        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).start < end && start < list.get(i).end) return false;
            }
        }
        list.add(new Interval(start, end));
        Collections.sort(list, Comparator.comparingInt(value -> value.start));
        return true;
    }

    // 33 41     47 50
    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
