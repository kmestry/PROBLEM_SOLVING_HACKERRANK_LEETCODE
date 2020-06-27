package com.hackerrank.hackinterview.asiapacific.june2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumXor {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String binaryString = bufferedReader.readLine().trim();
            int maximumSetBitsInString = Integer.parseInt(bufferedReader.readLine());
            String result = findStringWithMaximumXor(binaryString, maximumSetBitsInString);
            //String result = maxXorOptimized(binaryString, maximumSetBitsInString);
            System.out.println(result);
        }


    }


    private static String findStringWithMaximumXor(String binaryString, int maximumSetBitsInString) {
        int maxSetBitsCounter = 0;
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            if (maximumSetBitsInString == maxSetBitsCounter) {
                //System.out.println("resultString" + resultString);
                int remainingZeros = binaryString.length() - resultString.length();
                for (int j = 0; j < remainingZeros; j++) {
                    resultString.append("0");
                }
                break;
            }
            int bit = binaryString.charAt(i);
            String maxBit = "0";
            if (bit == 48) {
                maxBit = "1";
                maxSetBitsCounter++;
            }
            resultString.append(maxBit);


        }
        return resultString.toString();

    }


}