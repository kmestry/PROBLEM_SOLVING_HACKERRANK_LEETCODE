package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximizeDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {

        // /[1,0,0,0,1,0,1]
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                list.add(i);  // [0 , 4, 6]
            }
        }

        int maxDistance = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {

                int closest = Integer.MAX_VALUE;
                for (Integer integer : list) {

                    closest = Math.min(closest, Math.abs(integer - i));

                    if (closest == 1)
                        break;
                }

                maxDistance = Math.max(maxDistance, closest);
            }
        }

        return maxDistance;


    }
}
