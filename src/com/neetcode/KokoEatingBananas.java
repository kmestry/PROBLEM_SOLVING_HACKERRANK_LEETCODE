package com.neetcode;

public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();


        kokoEatingBananas.minEatingSpeed(new int[]{312884470}, 312884469);
    }
    //[30,11,23,4,20], h = 5

    public int minEatingSpeed(int[] piles, int h) {


        int min = 1;
        int max = getMax(piles);

        while (min < max) {
            int mid = (min + max) / 2;
            int hrsTillNow = 0;
            for (int i = 0; i < piles.length; i++) {

                int bananas = piles[i];

                if (bananas % mid == 0) {
                    hrsTillNow += bananas / mid;
                } else {
                    hrsTillNow += (bananas / mid) + 1;
                }
            }
            if (hrsTillNow > h) {
                min = mid + 1;
            } else if (hrsTillNow <= h) {
                max = mid;
            }

        }

        return max;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        return max;
    }
}





