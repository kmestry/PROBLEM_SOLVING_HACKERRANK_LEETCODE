package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class AngleBetweenHandsOfClock1344 {

    public static void main(String[] args) {
        double angle = angleClock(3, 15);
        System.out.println("angle = " + angle);

    }

    // 1 minute =6 degree
    public static double angleClock(int hour, int minutes) {
        //hour minute map
        Map<Integer, Integer> hourMinuteMap = new HashMap<>();

        hourMinuteMap.put(12, 0);
        hourMinuteMap.put(1, 5);
        hourMinuteMap.put(2, 10);
        hourMinuteMap.put(3, 15);
        hourMinuteMap.put(4, 20);
        hourMinuteMap.put(5, 25);
        hourMinuteMap.put(6, 30);
        hourMinuteMap.put(7, 35);
        hourMinuteMap.put(8, 40);
        hourMinuteMap.put(9, 45);
        hourMinuteMap.put(10, 50);
        hourMinuteMap.put(11, 55);

        //convert minutes to degree.
        double degree = minutes * 6 - hourMinuteMap.get(hour) * 6;

        //hour degree calculate
        // 1 window between hour has 5 dashes. so 30 degree as 1 dash is 6 degree.
        double hourMinutes = minutes / Double.valueOf(60);
        double varianceInHourDegree = 30 * hourMinutes;

        double degreeCalculated = Math.abs(degree - varianceInHourDegree);
        double otherDegreeCalculated = 360 - degreeCalculated;

        return degreeCalculated > otherDegreeCalculated ? otherDegreeCalculated : degreeCalculated;

    }
}
