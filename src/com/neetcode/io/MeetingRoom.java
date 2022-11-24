package com.neetcode.io;

import java.util.Comparator;
import java.util.List;


public class MeetingRoom {

    /**
     * Definition of Interval:
     * public class Interval {
     *     int start, end;
     *     Interval(int start, int end) {
     *         this.start = start;
     *         this.end = end;
     *     }
     * }
     */


    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here

        intervals.sort(Comparator.comparingInt(o -> o.start));

        int right = 1;
        int left = 0;

        while (right < intervals.size()) {
            if (intervals.get(right).start < intervals.get(left).end) {
                return false;
            } else {
                left++;
                right++;
            }
        }

        return true;
    }

}


class Interval {

    int start, end;


    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
