package com.leetcode;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {


        int x = 0;
        int y = 0;
        char dir = 'N'; //initial direction is north
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                if (dir == 'N') {
                    y++;
                } else if (dir == 'W') {
                    x--;
                } else if (dir == 'E') {
                    x++;
                } else if (dir == 'S') {
                    y--;
                }
            } else if (c == 'L') {
                if (dir == 'N') {
                    dir = 'W';
                } else if (dir == 'W') {
                    dir = 'S';
                } else if (dir == 'E') {
                    dir = 'N';
                } else if (dir == 'S') {
                    dir = 'E';
                }
            } else if (c == 'R') {
                if (dir == 'N') {
                    dir = 'E';
                } else if (dir == 'W') {
                    dir = 'N';
                } else if (dir == 'E') {
                    dir = 'S';
                } else if (dir == 'S') {
                    dir = 'W';
                }
            }
        }


        if (x == 0 && y == 0) return true;

        return dir != 'N';
    }
}
