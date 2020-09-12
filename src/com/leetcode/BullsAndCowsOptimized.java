package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCowsOptimized {

    public String getHint(String secret, String guess) {

        String result = "";
        if (secret.equals(guess)) {
            return result + secret.length() + "A0B";
        }

        //"1122"
        //"2211"
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int bullCount = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bullCount++;
            } else {

                populateMaps(map1, map2, c1, c2);

            }
        }
        result += bullCount + "A";

        int cowCount = 0;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                if (map2.containsKey(key) && map2.get(key) > 0) {
                    cowCount++;
                    map2.put(key, map2.get(key) - 1);
                }
            }
        }

        result += cowCount + "B";

        return result;

    }

    private void populateMaps(Map<Character, Integer> map1, Map<Character, Integer> map2, char c1, char c2) {
        if (map1.containsKey(c1)) {
            map1.put(c1, map1.get(c1) + 1);
        } else {
            map1.put(c1, 1);
        }

        if (map2.containsKey(c2)) {
            map2.put(c2, map2.get(c2) + 1);
        } else {
            map2.put(c2, 1);
        }
    }
}
