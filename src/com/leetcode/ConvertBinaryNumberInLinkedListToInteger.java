package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryNumberInLinkedListToInteger {

    public int getDecimalValue(ListNode head) {

        ListNode traverse = head;
        List<Integer> list = new ArrayList<>();

        while (traverse != null) {
            list.add(traverse.val);
            traverse = traverse.next;
        }

        int result = 0;
        int power = 0;

        for (int i = list.size() - 1; i >= 0; i--) {

            int intVal = list.get(i);

            if (intVal == 1) {
                result += Math.pow(2, power);
            }

            power++;
        }

        return result;
    }

    //https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/discuss/629087/Detailed-explanation-Java-%3A-faster-than-100.00

    public int getDecimalValueOptimized(ListNode head) {

        int result = 0;

        ListNode traverse = head;

        while (traverse != null) {
            result *= 2;
            result += traverse.val;
            traverse = traverse.next;
        }

        return result;
    }
}
