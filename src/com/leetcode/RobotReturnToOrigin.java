package com.leetcode;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {

        int lCount = 0;
        int rCount = 0;
        int uCount = 0;
        int dCount = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);

            switch (c) {
                case 'U':
                    uCount++;
                    break;
                case 'L':
                    lCount++;
                    break;
                case 'R':
                    rCount++;
                    break;
                case 'D':
                    dCount++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid value Found!!");
            }

        }


        return dCount == uCount && rCount == lCount;

    }
}
