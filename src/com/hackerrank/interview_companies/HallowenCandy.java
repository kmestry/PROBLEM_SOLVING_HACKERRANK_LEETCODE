package com.hackerrank.interview_companies;

import java.util.Arrays;
import java.util.List;

public class HallowenCandy {

    public static void main(String[] args) {
        HallowenCandy hallowenCandy = new HallowenCandy();
        hallowenCandy.minimumCandiesPerHour(Arrays.asList(2, 2, 2, 2), 8);
    }

    /* 4
     9
     11
     17


     8*/
    public int minimumCandiesPerHour(List<Integer> candyPiles, int numHours) {
        // Write your code here


        int maximumCandies = candyPiles.stream().max(Integer::compareTo).get();

        int countNumHours = 0;

        for (int i = 1; i <= maximumCandies; i++) {
            for (Integer candyPile : candyPiles) {
                int hoursRequiredToEatCandies = (int) Math.ceil((double) candyPile / (double) i);
                countNumHours += hoursRequiredToEatCandies;
                if (countNumHours > numHours) {
                    break; //early break
                }
            }
            if (countNumHours <= numHours) {
                return i;
            }
            countNumHours = 0; // reinitialize the hours for next loop

        }

        return -1;

    }

}
