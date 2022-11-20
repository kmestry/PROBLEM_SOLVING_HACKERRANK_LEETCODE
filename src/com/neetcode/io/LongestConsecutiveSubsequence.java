package com.neetcode.io;

import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        // new LongestConsecutiveSubsequence().longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6});
        //  new LongestConsecutiveSubsequence().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});

        new LongestConsecutiveSubsequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();

        for (int num : nums) {

            set.add(num);

        }


        System.out.println(set);

        Integer curr = null;
        int maxLength = 0;
        int currLength = 0;
        for (Integer entry : set) {
            if (curr == null) {
                curr = entry;
                currLength++;
            } else if (entry != curr + 1) {
                System.out.println("==currLength=" + currLength);
                maxLength = Math.max(maxLength, currLength);
                currLength = 1;
                curr = entry;
            } else {
                currLength++;
                curr = entry;
            }

        }
        return Math.max(maxLength, currLength);

    }
}
