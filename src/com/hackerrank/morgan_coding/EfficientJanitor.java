package com.hackerrank.morgan_coding;

import java.util.Collections;
import java.util.List;

public class EfficientJanitor {
    private static final float MAX_WEIGHT = 3.0f;


    // Write your code here

    //max weight 3.0
    //case 0
    // 1.01 , 1.99, 2.5 , 1.5, 1.01
    // 1.01 1.01 1.5 1.99 2.5

    //case 1
    //[1.01, 1.01, 1.01, 1.4, 2.4]

    //case 2
    // [1.01. 1.991, 1.32, 1.4]
    //sort 1.01 1.32 1.4 1.991


    public static int efficientJanitor(List<Float> weight) {
        // Write your code here
        // {1.01 , 1.99, 2.5 , 1.5, 1.01}


        Collections.sort(weight);
        int minTrips = 0;

        int pointer1 = 0;
        int pointer2 = weight.size() - 1;

        while (pointer1 <= pointer2) {
            float comboWeight = weight.get(pointer1) + weight.get(pointer2);
            if (comboWeight <= MAX_WEIGHT) {
                minTrips++;
                pointer1++;
                pointer2--;
            } else {
                if (weight.get(pointer1) > weight.get(pointer2)) {
                    pointer1++;
                } else {
                    pointer2--;
                }
                minTrips++;
            }
        }

        return minTrips;
    }

}

