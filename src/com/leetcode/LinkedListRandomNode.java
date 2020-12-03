package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
        int result = solution.getRandom();
        System.out.println("result = " + result);
    }

    static class Solution {


        List<Integer> list = new ArrayList<>();


        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            ListNode traverse = head;
            while (traverse != null) {
                list.add(traverse.val);
                traverse = traverse.next;
            }
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            Random rand = new Random();
            int randomElement = list.get(rand.nextInt(list.size())); // get index between 0 to list size - 1 . nextInt has
            //equal probability.
            return randomElement;
        }
    }

}
