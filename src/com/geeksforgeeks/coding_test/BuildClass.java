package com.geeksforgeeks.coding_test;

class BuildWalls {

    //This function will return the max height calculated as per conditions.
    public static int maxHeight(int[] stickPositions, int[] sticksHeight) {
        int maxeight = 0;
        for (int i = 0; i < stickPositions.length - 1; i++) {
			/*Space between both the sticks is calculated. If it is more than one then height is incremented by 1 unit
			from the given height*/
            int space = stickPositions[i + 1] - stickPositions[i];
            if (space > 1) {
                maxeight = sticksHeight[i];
                for (int j = 1; j < space; j++) {
                    if (j == 1) {
                        maxeight++;
                    } else if (maxeight < sticksHeight[i + 1]) {
                        maxeight++;
                    }
                }
            }
        }
        return maxeight;
    }

    public static void main(String[] args) {


        System.out.println("final max " + maxHeight(new int[]{1, 3, 7}, new int[]{4, 3, 3}));
    }

}