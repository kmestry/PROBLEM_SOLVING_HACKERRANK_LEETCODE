package com.hackerrank.warmup;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class TimeConversion {


    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the timeConversion function below.
     *
     *       07:05:45PM
     *       19:05:45
     *
     *       12:45:54PM
     */
    static String timeConversion(String s) {
        if (Objects.nonNull(s) && s.contains(":")) {
            String[] inputArray = s.split(":");
            if (inputArray.length == 3) {
                String amPmIdentifier = inputArray[2];
                String amPmValue = amPmIdentifier.substring(2);
                String amPmValueWithoutSuffix = amPmIdentifier.substring(0, 2);
                if ("PM".equals(amPmValue) && Integer.parseInt(inputArray[0]) == 12) {
                    return s.substring(0, 8);
                } else if ("AM".equals(amPmValue) && Integer.parseInt(inputArray[0]) == 12) {
                    return String.join(":", "00", inputArray[1], inputArray[2].substring(0, 2));
                } else if ("PM".equals(amPmValue)) {
                    String result = String.valueOf(Integer.parseInt(inputArray[0]) + 12);

                    return String.join(":", result, inputArray[1], amPmValueWithoutSuffix);
                } else {
                    return s.substring(0, 8);
                }
            }
        }

        return "";
    }

    public static void main(String[] args) throws IOException {

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println("result = " + result);

    }
}


