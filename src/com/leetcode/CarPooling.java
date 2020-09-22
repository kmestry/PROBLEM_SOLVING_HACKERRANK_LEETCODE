package com.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

    // [[2,1,5],[3,3,7]], capacity = 4
    public boolean carPooling(int[][] trips, int capacity) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < trips.length; i++) {

            int[] trip = trips[i];// get the trip array inside of trips

            int passengers = trip[0]; // number of passengers is at 0th position.

            //maintain tuple or pair of (startposition, passengers) and (endposition, -passengers)

            //negative -passengers in endposition as we need to
            //remove passengers from the count when we drop them.


            if (map.containsKey(trip[1])) {
                map.put(trip[1], map.get(trip[1]) + passengers);
            } else {
                map.put(trip[1], passengers);
            }

            if (map.containsKey(trip[2])) {
                map.put(trip[2], map.get(trip[2]) - passengers);
            } else {
                map.put(trip[2], -passengers);
            }
        }


        // we get sorted map here due to usage of TreeMap.
        int currentCapacity = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            //keep adding the passengers to current capacity.
            currentCapacity += entry.getValue();

            //if anytime current capacity is greater than capacity return false.
            if (currentCapacity > capacity)
                return false;
        }

        //true when all passengers can be dropped in trips array.
        return true;

    }


}
