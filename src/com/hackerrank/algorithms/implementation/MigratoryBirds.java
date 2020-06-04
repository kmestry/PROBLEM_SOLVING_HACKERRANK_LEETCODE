package com.hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birdsTypeMap = new TreeMap<>();

        arr.stream().forEach(integer -> {
            if (birdsTypeMap.containsKey(integer)) {
                birdsTypeMap.put(integer, birdsTypeMap.get(integer) + 1);
            } else {
                birdsTypeMap.put(integer, 1);
            }
        });

        int maxNoOfBirdsOfParticularType = birdsTypeMap.values().stream().max(Integer::compareTo).get();
        List<Map.Entry<Integer, Integer>> birdsTypeWithMaximumBirdsList = birdsTypeMap.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue() == maxNoOfBirdsOfParticularType).collect(Collectors.toList());

        return birdsTypeWithMaximumBirdsList.get(0).getKey();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        System.out.println("result = " + result);

        bufferedReader.close();
    }
}

