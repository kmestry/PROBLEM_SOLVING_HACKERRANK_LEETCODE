package com.leetcode;

import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        new AsteroidCollision().asteroidCollision(new int[]{-2, 10, -20, 5, 2, 1, -5
        });
    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {

                boolean insertAsteroidFlag = true;
                while (!stack.isEmpty() && stack.peek() > 0) {

                    if (stack.peek() == -asteroid) {
                        insertAsteroidFlag = false;
                        stack.pop();
                        break;
                    } else if (-asteroid > stack.peek()) {
                        stack.pop();
                    } else if (stack.peek() > -asteroid) {
                        insertAsteroidFlag = false;
                        break;
                    }
                }

                if (insertAsteroidFlag) {
                    stack.push(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];

        int index = result.length - 1;
        for (int i = 0; i < result.length; i++) {
            result[index] = stack.pop();
            index--;
        }


        return result;

    }

}
