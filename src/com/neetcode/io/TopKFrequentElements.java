package com.neetcode.io;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        //  new TopKFrequentElements().topKFrequentCountSort(new int[]{1,1,1,2,2,3}, 2);
        //new TopKFrequentElements().topKFrequentCountSort(new int[]{1}, 1);
        new TopKFrequentElements().topKFrequentCountSort(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6}, 10);
    }

    public int[] topKFrequentBruteForce(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //System.out.println(map);

        int maxCount = nums.length;
        int[] result = new int[k];
        int index = 0;
        while (maxCount > 0 && k > 0) {
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == maxCount) {
                    result[index] = e.getKey();
                    k--;
                    index++;
                    //map.remove(e.getKey());
                }
            }


            maxCount--;


        }

        return result;
    }

    public int[] topKFrequentPQ(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(map.entrySet());

        int[] res = new int[k];
        int i = 0;
        while (k > 0) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            res[i] = entry.getKey();
            i++;
            k--;
        }

        return res;
    }

    public int[] topKFrequentCountSort(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        Map<Integer, List<Integer>> keyList = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int mapKey = entry.getValue();

            if (keyList.containsKey(mapKey)) {
                List<Integer> list = keyList.get(mapKey);
                list.add(entry.getKey());
                keyList.put(mapKey, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                keyList.put(mapKey, list);
            }

        }
        System.out.println(keyList);
        int[] res = new int[k];
        int index = 0;
        int topElementCount = nums.length;
        while (k > 0 && index <= res.length - 1) {
            if (keyList.containsKey(topElementCount)) {
                List<Integer> list = keyList.get(topElementCount);

                for (Integer i : list) {
                    res[index] = i;
                    k--;
                    index++;

                }

                topElementCount--;

            } else {
                topElementCount--;
            }
        }

        return res;
    }
}
