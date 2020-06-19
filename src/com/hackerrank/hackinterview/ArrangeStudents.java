package com.hackerrank.hackinterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'arrangeStudents' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a  Boys array
     *  2. INTEGER_ARRAY b  Girls array
     * 5 3 8
     * 2 4 6
     */

    public static String arrangeStudents(List<Integer> a, List<Integer> b) {
        // Write your code here
        List<Integer> sortedBoysList = a.parallelStream().sorted().collect(toList());
        List<Integer> sortedGirlsList = b.parallelStream().sorted().collect(toList());

        List<Integer> sortedListBoysGirls = new ArrayList<>();
        sortedListBoysGirls.addAll(sortedBoysList);
        sortedListBoysGirls.addAll(sortedGirlsList);
        Collections.sort(sortedListBoysGirls);
        System.out.println(sortedListBoysGirls);

        final String[] result = {""};

        sortedListBoysGirls.stream().forEach(integer -> {
            if (sortedBoysList.contains(integer) && sortedGirlsList.contains(integer)) {
                //donothing
                // result[0] = result[0];


                if (result[0].length() > 0) {
                    if (result[0].charAt(result[0].length() - 1) == 'g') {
                        result[0] += "b";
                        sortedBoysList.remove(integer);
                    } else {
                        result[0] += "g";
                        sortedGirlsList.remove(integer);
                    }
                } else {
                    //result[0]+="b";
                    sortedBoysList.remove(integer);
                    //result[0]+="g";
                    sortedGirlsList.remove(integer);

                }
            } else if (sortedBoysList.contains(integer)) {
                result[0] += "b";
            } else if (sortedGirlsList.contains(integer)) {
                result[0] += "g";
            }


        });

        String resultBoyGirlString = result[0];
        int windowSize = 2; // as bg is the pattern to test.
        for (int i = 0; i < resultBoyGirlString.length(); i++) {
            if (windowSize > resultBoyGirlString.length()) {
                break;
            }
            String stringToCompare = resultBoyGirlString.substring(0, windowSize);
            if (stringToCompare.contains("bb") || stringToCompare.contains("gg")) {
                return "NO";
            }

            windowSize++;

        }

        return "YES";
    }
}

public class ArrangeStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String Result = Result1.arrangeStudents(a, b);
                System.out.println("Result1 = " + Result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

