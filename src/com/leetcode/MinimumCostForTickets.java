package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets {

    Map<Integer, Integer> map = new HashMap();

    public static void main(String[] args) {
        new MinimumCostForTickets().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
    }


    public int mincostTickets(int[] days, int[] costs) {
        return helper(days, costs, 0);
    }

    int helper(int[] days, int[] cost, int d) {

        if (d >= days.length) return 0;

        if (map.get(d) != null)
            return map.get(d);

        int oneDayPass = helper(days, cost, d + 1) + cost[0]; // check all scenarios of one day pass


        int i;
        for (i = d; i < days.length; i++) {
            if (days[i] >= days[d] + 7)
                break;
        }

        int sevenDayPass = helper(days, cost, i) + cost[1];


        for (i = d; i < days.length; i++) {
            if (days[i] >= days[d] + 30)
                break;
        }

        int thirtyDayPass = helper(days, cost, i) + cost[2];

        int result = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));

        map.put(d, result);
        return result;

    }
}
