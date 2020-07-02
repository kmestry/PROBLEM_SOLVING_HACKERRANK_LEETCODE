package com.hackerrank.algorithms.searching;

import java.util.Arrays;
import java.util.Scanner;

public class HackerLandRadioTransmitterApproach2 {

    static int hackerlandRadioTransmitters(int[] locationsOfHouses, int rangeOfTransmitter) {
        int minNumberOfTransmitters = 0;
        int lastHouse = 0;
        int index = 0;
        Arrays.sort(locationsOfHouses);

        while (index < locationsOfHouses.length) {

            lastHouse = index + 1;

            // houses that can be covered before the transmitter
            while (lastHouse < locationsOfHouses.length
                    && locationsOfHouses[lastHouse] - locationsOfHouses[index] <= rangeOfTransmitter) {
                lastHouse++;
            }

            index = lastHouse - 1;

            // houses that can be covered after the transmitter
            while (lastHouse < locationsOfHouses.length
                    && locationsOfHouses[lastHouse] - locationsOfHouses[index] <= rangeOfTransmitter) {
                lastHouse++;
            }

            index = lastHouse;
            minNumberOfTransmitters++;
        }

        return minNumberOfTransmitters;
    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int numberOfHouses = reader.nextInt();
        int rangeOfTransmitter = reader.nextInt();
        int[] locationsOfHouses = new int[numberOfHouses];

        for (int i = 0; i < numberOfHouses; i++) {
            locationsOfHouses[i] = reader.nextInt();
        }
        reader.close();

        int result = hackerlandRadioTransmitters(locationsOfHouses, rangeOfTransmitter);
        System.out.println(result);
    }
}
