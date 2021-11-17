package com.hackerrank.algorithms.searching;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class GridLandMetroStackApproach {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the gridlandMetro function below.
    static BigInteger gridlandMetro(long n, long m, long k, long[][] track) {

        AtomicLong counter = new AtomicLong();
        Map<Long, Long> trackMap = new HashMap<>();
        Map<Long, Stack<Long>> integerStackMap = new HashMap<>();
        Stack<Long> repeatedRowStack = new Stack<>();
        for (int l = 0; l < k; l++) {
            for (int i = 0; i < 1; i++) {
                if (trackMap.containsKey(track[l][i])) {
                    trackMap.put(track[l][i], trackMap.get(track[l][i]) + 1);
                } else {
                    trackMap.put(track[l][i], (long) 1);
                }
            }
        }

        for (int i = 0; i < track.length; i++) {
            for (int j = 0; j < track.length; j++) {
                long row = track[i][j];
                long column1 = track[i][j + 1];
                long column2 = track[i][j + 2];

                if (trackMap.get(row) == 1) {
                    counter.addAndGet(column2 - column1 + 1);
                } else if (trackMap.get(row) > 1) {
                    if (repeatedRowStack.isEmpty()) {
                        repeatedRowStack.push(column1);
                        repeatedRowStack.push(column2);
                        integerStackMap.put(row, repeatedRowStack);
                    }
                }
                break;

            }
        }

        List<List<Long>> listOfTuples = new ArrayList<>();
        Iterator hmIterator = integerStackMap.entrySet().iterator();
        List<Long> innerList = new ArrayList<>();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            Stack<Long> stackInner = (Stack<Long>) mapElement.getValue();

            int capacity = stackInner.size();

            while (capacity > 0) {
                while (!stackInner.isEmpty()) {
                    innerList.add(stackInner.pop());
                }
            }

        }



      /*  integerStackMap.entrySet().stream().forEach(longStackEntry -> {
            long firsElementInStack = longStackEntry.getValue().firstElement();
            long lastElementInStack = longStackEntry.getValue().lastElement();
            counter.addAndGet(lastElementInStack - firsElementInStack + 1);
        });
*/

        long nm = n * m;

        int placesWhereLampPostCanBePlaced = (int) (nm - counter.get());


        return BigInteger.valueOf(placesWhereLampPostCanBePlaced);
    }

    public static void main(String[] args) throws IOException {

        String[] nmk = scanner.nextLine().split(" ");

        long n = Long.parseLong(nmk[0]);

        long m = Long.parseLong(nmk[1]);

        long k = Long.parseLong(nmk[2]);

        long[][] track = new long[Math.toIntExact(k)][3];

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
