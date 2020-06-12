package com.hackerrank.algorithms.searching;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GridLandMetroOptimized {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the gridlandMetro function below.
    static BigInteger gridlandMetro(int n, int m, int k, long[][] track) {

        long counter = 0;
        Map<Long, Long> trackMap = new HashMap<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        for (int l = 0; l < track.length; l++) {
            for (int o = 0; o < track.length; o++) {
                long row = track[l][o];
                long column1 = track[l][o + 1];
                long column2 = track[l][o + 2];

                if (rowMap.containsKey((int) row)) {
                    rowMap.put((int) row, rowMap.get((int) row) + 1);
                } else {
                    rowMap.put(Math.toIntExact(row), 1);
                }
                for (long j = column1 - 1; j <= column2 - 1; j++) {
                    if ((trackMap.containsKey(j)) && (rowMap.get((int) row) > 1)) {
                        //trackMap.put(j, (long) 1);
                        // counter++;

                    } else {
                        trackMap.put(j, (long) 1);
                        counter++;
                    }

                }
                break;
            }
        }


        long nm = n * m;

        int placesWhereLampPostCanBePlaced = (int) (nm - counter);


        return BigInteger.valueOf(placesWhereLampPostCanBePlaced);
    }

    public static void main(String[] args) throws IOException {

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);

        int m = Integer.parseInt(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        long[][] track = new long[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        BigInteger result = gridlandMetro(n, m, k, track);

        System.out.println("result = " + result);


        scanner.close();
    }
}
