package com.leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        new BoatsToSavePeople().numRescueBoats(new int[]{1, 2}, 3);
    }

    // heavy with heaviest approach
    public int numRescueBoats(int[] people, int limit) {


        Arrays.sort(people);

        int middle = people.length / 2;

        int right = people.length - 1;

        for (int i = 0; i < middle; i++) {
            int temp = people[i];
            people[i] = people[right];
            people[right] = temp;
            right--;
        }


        boolean[] visited = new boolean[people.length];
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            if (visited[i]) continue;
            if (!visited[i] && people[i] == limit) {
                count++;
                visited[i] = true;
            } else if (people[i] < limit) {
                boolean pairFound = false;
                for (int j = i + 1; j < people.length; j++) {
                    if (!visited[j] && (people[i] + people[j]) <= limit) {
                        count++;
                        pairFound = true;
                        visited[j] = true;
                        visited[i] = true;
                        break;
                    }
                }
                if (!pairFound && !visited[i]) {
                    count++;
                    visited[i] = true;
                }
            }
        }

        return count;
    }
}
