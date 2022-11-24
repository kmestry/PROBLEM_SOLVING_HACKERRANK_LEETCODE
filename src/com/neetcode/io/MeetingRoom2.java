package com.neetcode.io;

import java.util.Arrays;
import java.util.List;

public class MeetingRoom2 {

    //[(0,30),(5,10),(15,20)]

    public static void main(String[] args) {
        new MeetingRoom2().minMeetingRooms(Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)));
    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int index = 0;
        for (Interval i : intervals) {
            start[index] = i.start;
            end[index] = i.end;
            index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0;
        int numberOfMeetingRoomsRequired = 0;

        int l = 0;
        int r = 0;
        while (l < start.length) {
            if (start[l] < end[r]) {
                numberOfMeetingRoomsRequired++;
                l++;
            } else {
                numberOfMeetingRoomsRequired--;
                r++;
            }

            res = Math.max(res, numberOfMeetingRoomsRequired);
        }

        return res;

    }

}

