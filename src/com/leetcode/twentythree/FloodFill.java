package com.leetcode.twentythree;

public class FloodFill {

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void helper(int[][] image, int r, int c, int srColor, int newColor) {
//        System.out.println("r :" + r);
//        System.out.println("c :" + c);
        if (r >= image.length || c >= image[0].length || r < 0 || c < 0 || image[r][c] != srColor) return;

        if (image[r][c] == srColor) {

            image[r][c] = newColor;

            helper(image, r + 1, c, srColor, newColor);
            helper(image, r - 1, c, srColor, newColor);
            helper(image, r, c + 1, srColor, newColor);
            helper(image, r, c - 1, srColor, newColor);
        } else {
        }
    }
}
