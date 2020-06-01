package com.hackerrank.Strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SuperReducedString {

    /*
     *   baabccddd
     * */
    static String superReducedString(String s) {
        String[] stringArray = s.split("");
        Arrays.sort(stringArray);
        Map<String, Integer> map = new LinkedHashMap<>();
        Map<String, Integer> mapResult = new LinkedHashMap<>();
        String result = "";
        for (int i = 0; i < stringArray.length; i++) {
            if (map.containsKey(stringArray[i])) {
                Integer value = map.get(stringArray[i]);
                map.put(stringArray[i], value + 1);

            } else {
                map.put(stringArray[i], 1);
            }
        }
        map.forEach((s1, integer) -> {
            if (integer % 2 != 0) {
                mapResult.put(s1, integer);
            }
        });
        if (mapResult.size() > 0) {
            for (String key : mapResult.keySet()) {
                result += key;
            }
        } else {
            return "Empty String";
        }

        System.out.println("result = " + result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        //superReducedString("txxmubonuhlaryeuujgftedrmmhmaadxrplneqpwhsketqicdpqlecluydmgykrubgmpwfqviabkjoiqdftbbwwgiuudmgrdbkrr");
        superReducedString("acdqglrfkqyuqfjkxyqvnrtysfrzrmzlygfveulqfpdbhlqdqrrqdqlhbdpfqluevfgylzmrzrfsytrnvqyxkjfquyqkfrlacdqj");
    }
}
