package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCyclePractise {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {

        Set<Integer> set = new HashSet<>();
        ListNode traversalNode = head;

        while (traversalNode != null) {

            if (set.contains(traversalNode.hashCode())) return true;
            else set.add(traversalNode.hashCode());

            traversalNode = traversalNode.next;
        }

        return true;
    }

    public boolean hasCycleHareTortoise(ListNode head) {

        ListNode hare = head;   // hare will run 2x
        ListNode tortoise = head;  // tortoise will run x


        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise.equals(hare)) return true;
        }

        return false;
    }
}
