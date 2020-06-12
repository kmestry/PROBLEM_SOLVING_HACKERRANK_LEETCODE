package com.hackerrank.algorithms.searching;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class GridLandMetro {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the gridlandMetro function below.
    static BigInteger gridlandMetro(long n, long m, long k, long[][] track) {

        long[][] gridArray = new long[(int) n][(int) m];


        long counter = 0;
        for (long l = 0; l < track.length; l++) {
            for (long o = 0; o < track.length; o++) {
                long row = track[(int) l][(int) o];
                long column1 = track[(int) l][(int) (o + 1)];
                long column2 = track[(int) l][(int) (o + 2)];


                for (long j = column1 - 1; j <= column2 - 1; j++) {
                    if (gridArray[(int) (row - 1)][(int) j] == 0) {
                        gridArray[(int) (row - 1)][(int) j] = 1;
                        counter++;
                    }
                }
                break;
            }
        }


        long placesWhereLampPostCanBePlaced = n * m - counter;

        return BigInteger.valueOf(placesWhereLampPostCanBePlaced);
    }

    public static void main(String[] args) throws IOException {

        String[] nmk = scanner.nextLine().split(" ");

        long n = Long.parseLong(nmk[0]);

        long m = Long.parseLong(nmk[1]);

        long k = Long.parseLong(nmk[2]);

        long[][] track = new long[(int) k][3];

        for (long i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (long j = 0; j < 3; j++) {
                long trackItem = Long.parseLong(trackRowItems[(int) j]);
                track[(int) i][(int) j] = trackItem;
            }
        }

        BigInteger result = gridlandMetro(n, m, k, track);

        System.out.println(result);


        scanner.close();
    }
}
