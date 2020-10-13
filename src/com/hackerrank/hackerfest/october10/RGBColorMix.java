package com.hackerrank.hackerfest.october10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RGBColorMix {
    public static List<String> mixColors(List<List<Integer>> colors, List<List<Integer>> queries) {
        // Write your code here

// 4 3
// 1 1 1
// 0 0 2
// 5 0 0
// 5 2 2
// 0 0 2
// 5 1 2
// 5 3 2
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> list = queries.get(i);
            if (colors.contains(list)) {
                resultList.add("YES");

            } else {
                int r = list.get(0);
                int b = list.get(1);
                int g = list.get(2);

                boolean isRFound = false;
                boolean isBFound = false;
                boolean isGFound = false;
                for (int j = 0; j < colors.size(); j++) {
                    List<Integer> colorList = colors.get(j);
                    int RColor = colorList.get(0);
                    int BColor = colorList.get(1);
                    int GColor = colorList.get(2);

                    if (!isRFound) {
                        if (RColor == r) {
                            isRFound = true;
                        }
                    }

                    if (!isBFound) {
                        if (BColor == b) {
                            isBFound = true;
                        }
                    }

                    if (!isGFound) {
                        if (GColor == g) {
                            isGFound = true;
                        }
                    }

                }
                if (isRFound && isBFound && isGFound) {
                    resultList.add("YES");
                } else {
                    resultList.add("NO");
                }

            }
        }

        return resultList;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> colors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] colorsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> colorsRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int colorsItem = Integer.parseInt(colorsRowTempItems[j]);
                colorsRowItems.add(colorsItem);
            }

            colors.add(colorsRowItems);
        }

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<String> result = RGBColorMix.mixColors(colors, queries);


        bufferedReader.close();
    }

}

