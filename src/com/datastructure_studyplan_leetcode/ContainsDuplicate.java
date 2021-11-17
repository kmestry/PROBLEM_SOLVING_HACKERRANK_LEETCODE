package com.datastructure_studyplan_leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for (int i : nums) {
            if (seen.contains(i))
                return true;
            seen.add(i);
        }

        return false;
    }
}
