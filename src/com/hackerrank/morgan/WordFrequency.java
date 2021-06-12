package com.hackerrank.morgan;

import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
           /*"good is good is good as a lion"
                   "good" : 3
                    "is" : 2
                    "as", "a" , "lion" : 1*/

        WordFrequency wordFrequency = new WordFrequency();
        wordFrequency.printNthHighest("sa", 0);

    }

    private void printNthHighest(String sentence, int n) {
        String[] strings = sentence.split(" ");

        Map<String, Integer> map = new HashMap<>();
        //integer, value list<Strings>
        Map<Integer, List<String>> copyMap = new HashMap<>();
        map.put("good", 3);
        map.put("is", 2);
        map.put("as", 1);
        /*map.put("a", 1);
        map.put("lion", 1);*/

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort(Collections.reverseOrder());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();

            List<String> list_cp;
            if (copyMap.containsKey(value)) {
                list_cp = copyMap.get(value);
            } else {
                list_cp = new ArrayList<>();
            }
            list_cp.add(key);
            copyMap.put(value, list_cp);
        }

        int nthNum = list.get(n - 1);
        System.out.println(copyMap.get(nthNum));

        //PriorityQueue
     /*   map.put("a" , 1);
        map.put("lion" , 1);*/
        // set put  3,2,1


    }


}
