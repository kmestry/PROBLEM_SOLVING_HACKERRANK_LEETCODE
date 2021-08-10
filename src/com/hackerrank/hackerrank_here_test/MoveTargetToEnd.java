package com.hackerrank.hackerrank_here_test;

import java.util.Arrays;
import java.util.List;

public class MoveTargetToEnd {

    public static void main(String[] args) {
        MoveTargetToEnd moveTargetToEnd = new MoveTargetToEnd();
        //moveTargetToEnd.moveTargetToEnd(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2);
        moveTargetToEnd.moveTargetToEnd(Arrays.asList(1, 1, 3, 5, 6), 1);
    }

    // Target: 9 * * Output:  [9, 1, 9, 9, 9, 3, 9, 4].
    public List<Integer> moveTargetToEnd(List<Integer> list, int target) {

/*      Input: arr = [2, 1, 2, 2, 2, 3, 4, 2], K = 2
        Output: [4, 1, 3, 2, 2, 2, 2, 2]*/
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            if (list.get(left) == target && list.get(right) == target) {
                right--;
            } else if (list.get(left) == target && list.get(right) != target) {
                int temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
            } else {
                left++;
                //right--;
            }

        }

        return list;

    }

}
