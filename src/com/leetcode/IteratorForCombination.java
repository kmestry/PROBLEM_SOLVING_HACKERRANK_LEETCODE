package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class IteratorForCombination {
    Queue<String> stringQueue;

    public IteratorForCombination(String characters, int combinationLength) {
        this.stringQueue = new LinkedList<>();

        generateCombination(characters, 0, "", combinationLength, stringQueue);

    }

    public static void main(String[] args) {
        IteratorForCombination iterator = new IteratorForCombination("abc", 2);

        iterator.next(); // returns "ab"
        iterator.hasNext(); // returns true
        iterator.next(); // returns "ac"
        iterator.hasNext(); // returns true
        iterator.next(); // returns "bc"
        iterator.hasNext(); // returns false
    }

    private void generateCombination(String characters, int index, String generatedStringTillNow, int combinationLength, Queue<String> stringQueue) {

        if (combinationLength == 0) {
            stringQueue.add(generatedStringTillNow);
            return;
        }

        for (int i = index; i < characters.length(); i++) {
            generateCombination(characters, i + 1, generatedStringTillNow + characters.charAt(i), combinationLength - 1, stringQueue);
        }
    }

    public String next() {
        return stringQueue.poll();

    }

    public boolean hasNext() {
        return !stringQueue.isEmpty();
    }
}
