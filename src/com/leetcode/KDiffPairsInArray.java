package com.leetcode;






public class KDiffPairsInArray {

    //brute force initial solution.
    /*public int findPairs(int[] nums, int k) {
        //[3,1,4,1,5], k = 2
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                int firstNum = nums[i];
                int secondNum = nums[j];

                if (i != j && !set.contains(new Pair<>(firstNum, secondNum))
                        && firstNum <= secondNum && secondNum - firstNum == k) {
                    //System.out.println(firstNum);
                    //System.out.println(secondNum);
                    set.add(new Pair<>(firstNum, secondNum));
                    count++;
                }


            }
        }

        return count;
    }*/
}
