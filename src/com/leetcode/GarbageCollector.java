package com.leetcode;

public class GarbageCollector {
    Short story = 5;

    public static void main(String[] args) {
        GarbageCollector g1 = new GarbageCollector();
        GarbageCollector g2 = new GarbageCollector();
        GarbageCollector g3 = g1.go(g2);
        g1 = null;

        // Only one CardBoard object (c1) is eligible,
        // but it has an associated Short wrapper object that is also eligible.
        //total 2 objects
    }

    GarbageCollector go(GarbageCollector gc) {
        gc = null;
        return gc; //
    }
}
