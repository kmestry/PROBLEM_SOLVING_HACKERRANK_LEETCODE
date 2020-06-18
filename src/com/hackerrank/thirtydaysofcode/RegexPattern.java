package com.hackerrank.thirtydaysofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegexPattern {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> nameList = new ArrayList<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            if (emailID.contains("@gmail.com")) {
                nameList.add(firstName);
            }


        }

        nameList.stream().sorted().forEach(s -> System.out.println(s));


        scanner.close();
    }


}

