package com.leetcode;

import java.util.*;

public class JumpGame4 {

    public static void main(String[] args) {
      /*  int res = new JumpGame4().minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
        System.out.println("res = " + res);*/

        int res = new JumpGame4().minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13});
        System.out.println("res = " + res);
    }

    public int minJumps(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            List<Integer> list;
            if (map.containsKey(val)) {
                list = map.get(val);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(val, list);
        }

        //System.out.println(map);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); //0th index added to queue.
        boolean[] visited = new boolean[arr.length];

        int jump = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int index = queue.poll();

                if (index < 0 || index >= arr.length || visited[index]) {
                    continue;
                }
                if (index == arr.length - 1) {
                    return jump;
                }

                if (index + 1 < arr.length && !visited[index + 1]) {
                    queue.offer(index + 1);
                }
                if (index - 1 >= 0 && !visited[index - 1]) {
                    queue.offer(index - 1);
                }


                if (map.containsKey(arr[index])) {
                    List<Integer> list = map.get(arr[index]);
                    for (int indexInList : list) {
                        if (indexInList != index && !visited[indexInList]) {
                            queue.offer(indexInList);
                        }
                    }
                    visited[index] = true;
                    map.remove(arr[index]);
                }
            }
            jump++;
        }

        return -1;
    }


}



