package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCallsOptimized {

    Queue<Integer> queue;

    public NumberOfRecentCallsOptimized() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {

        queue.offer(t);

        while (queue.peek() < t - 3000)
            queue.poll();

        return queue.size();
    }
}
