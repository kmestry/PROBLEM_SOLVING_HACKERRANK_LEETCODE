package com.geeksforgeeks.arrays;

public class GETest {

    public static void main(String[] args) {
        GETest test = new GETest();
        int result = test.solve(5, 8, new int[]{2, 1, 4, 2, 3, 2, 2, 6});
        int result_1 = test.solve(3, 8, new int[]{2, 1, 4, 2, 3, 2, 2, 6});
        // 0 1 2 3 4 5 6 7

        // 1 2 2 2 2 3 4 6

        //l = 0 , r = 7take 6-1 = 5 abs diff, desired_res close 5 - 3 = 2; 2 > 0. hence reduce Right, store sum = 7 and mindiff = 2
        // l = 0, r = 6,take 4- 1 = 3 abs diff, desired_res close 3-3 = 0; 0 == 0. reduce l, r. store sum  = 5 , and mindiff till now = 0;
        // l = 1, r = 5, take 3-2 = 1 abs diff, desred_res clos = 3 - 1 = 2, 2 > 0, hence reduce right, sum , mindiff not updated
        // l = 1, r = 4  tale 2- 2 = 0 abs diff, desired_red close = 3 - 0 = 3. 3 > 0 , hence reduce right,
        System.out.println(result);
    }

    int solve(int desired_result, int n, int[] powers) {
// TLE solution.
        int summation = Integer.MAX_VALUE;
        int diffBetweenDesiredResult = Integer.MAX_VALUE;
        for (int i = 0; i < powers.length; i++) {
            for (int j = i + 1; j < powers.length; j++) {
                int diff = Math.abs(powers[i] - powers[j]);
                // System.out.println("diff :"+diff);
                int sum = powers[i] + powers[j];
                // System.out.println("sum :"+sum);
                int desiredResultCloseness = Math.abs(diff - desired_result);
                // System.out.println("desiredResultCloseness :"+desiredResultCloseness);

                if ((desiredResultCloseness <= diffBetweenDesiredResult)) {
                    // System.out.println("desiredResultCloseness INSIDE :");
                    if (desiredResultCloseness == diffBetweenDesiredResult) {
                        summation = Math.min(sum, summation);
                    } else {
                        summation = sum;
                        diffBetweenDesiredResult = desiredResultCloseness;
                    }

                }
            }
        }


        return summation;
    }
}
/*2
3
2 1 2
3
1 2 3

6
9
 static long solve(int N, int[] arr){
       // Type your code here*/


