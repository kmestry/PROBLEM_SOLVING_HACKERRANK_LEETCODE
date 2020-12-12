package com.leetcode;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) return true;

        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {

            if (n == 0) {
                return true;
            }
            if (flowerbed[i] == 0) {

                if (i == 0) {
                    if (i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else {
                    if (i + 1 < flowerbed.length && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }

        }

        return n == 0;

    }
}
