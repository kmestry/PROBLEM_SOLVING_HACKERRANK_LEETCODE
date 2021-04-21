package com.geeksforgeeks.contest.samplecontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CountGFGOccurrences {
    public static void main(String[] args) throws IOException {

        CountGFGOccurrences gfgOccurrences = new CountGFGOccurrences();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st
                = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        while (n-- > 0) {
            String input = br.readLine();
            list.add(input);
        }

        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            int occurrence = gfgOccurrences.countOccurrence(s);
            result.add(occurrence);
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }


    }

    // geefgfgksforgfgeeks
    private int countOccurrence(String input) {
        String baseString = "gfg";
        int start = 0;
        int end = 2;
        int count = 0;

        while (end < input.length()) {

            if (baseString.equals(input.substring(start, end + 1))) {
                count++;
            }

            start++;
            end++;
        }
        return count == 0 ? -1 : count;

    }
}
