package com.hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.*;

public class AcmIcpcTeamBitwise {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the acmTeam function below.
            /*10101
              11100
              11010
              00101  */
    static int[] acmTeam(String[] topic) {
        int[] result = new int[2];
        List<Integer> maxTopicList = new ArrayList<>();
        int maxTopicsTeamCanKnow = 0;
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < topic.length; i++) {
            String bitStringOuter = topic[i];
            for (int j = i + 1; j < topic.length; j++) {
                String bitStringInner = topic[j];
                int maxTopicsBetweenTwo = maxNumberOfTopicBetweenTwo(bitStringOuter, bitStringInner);
                // maxTopicList.add(maxTopicsBetweenTwo);

                if (resultMap.containsKey(maxTopicsBetweenTwo)) {
                    resultMap.put(maxTopicsBetweenTwo, resultMap.get(maxTopicsBetweenTwo) + 1);
                } else {
                    resultMap.put(maxTopicsBetweenTwo, 1);
                }


            }
        }
        maxTopicsTeamCanKnow = resultMap.keySet().parallelStream().max(Integer::compareTo).get();

        result[0] = maxTopicsTeamCanKnow;
        result[1] = resultMap.get(maxTopicsTeamCanKnow);

        return result;

    }

    static int maxNumberOfTopicBetweenTwo(String bitwiseString1, String bitwiseString2) {

        int counterMaxTopic = 0;
        for (int i = 0; i < bitwiseString1.length(); i++) {
            if (!(bitwiseString1.charAt(i) == 48 & bitwiseString2.charAt(i) == 48)) {
                counterMaxTopic++;
            }
        }
        return counterMaxTopic;

    }

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            System.out.println("result = " + result[i]);
        }


        scanner.close();
    }
}
