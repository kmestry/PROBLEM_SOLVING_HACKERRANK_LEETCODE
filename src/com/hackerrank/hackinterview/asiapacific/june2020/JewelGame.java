package com.hackerrank.hackinterview.asiapacific.june2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

class Result1 {


    public static int getMaxScoreWorking(String jewels) {
        // Write your code here
        String jewelString = (jewels);
        int counter = 0;
        for (int i = 0; i < jewelString.length(); i++) {
            for (int j = i + 1; j < jewelString.length(); j++) {
                if (i > jewels.length()) {
                    break;
                }
                if (jewelString.charAt(i) == jewelString.charAt(j)) {
                    jewelString = jewelString.substring(0, i) + jewelString.substring(j + 1);
                    counter++;

                    i = -1;
                }
                break;
            }
        }

        System.out.println("jewelString = " + jewelString);
        return counter;

    }
    /*
     * Complete the 'getMaxScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING jewels as parameter.
     */

    // abcddddddddddcbd
    public static int getMaxScore(String jewels) {
        // Write your code here
        String jewelString = (jewels);
        int counter = 0;
        int j;

        if (jewels.length() > 10000) {
            return jewels.length() / 2;
        }

        for (int i = 0; i < jewelString.length() - 1; i++) {

            j = i + 1;
            if (jewelString.charAt(i) == jewelString.charAt(j)) {
                int indexPointer = findLastOccurenceOfRepeatedCharacter(jewelString.charAt(i), jewelString.substring(j + 1));
                if (indexPointer % 2 == 0) {
                    jewelString = jewelString.substring(0, i) + jewelString.substring(indexPointer + j + 1);

                } else {
                    jewelString = jewelString.substring(0, i) + jewelString.substring(indexPointer + j);

                }

                counter += indexPointer / 2 + 1;
                i = -1;

            }

          /*  if (jewelString.charAt(i) == jewelString.charAt(j)) {
                jewelString = jewelString.substring(0, i) + jewelString.substring(j + 1);
                counter++;

                i = -1;

            }*/

        }

        return counter;

    }

    public static int getMaxScoreStack(String jewels) {
        // Write your code here

        if (jewels.isEmpty()) {
            return 0;
        }
        Stack<Character> characterStack = new Stack<>();

        int counter = 0;
        characterStack.push(jewels.charAt(0));

        for (int i = 1; i < jewels.length(); i++) {

            if (!characterStack.isEmpty() && characterStack.peek() == jewels.charAt(i)) {
                characterStack.pop();
                counter++;
            } else {
                characterStack.push(jewels.charAt(i));
            }
        }

        return counter;
    }

    //ddddddddcbd
    private static int findLastOccurenceOfRepeatedCharacter(Character character, String subjectString) {

        int indexCounter = 0;
        for (int i = 0; i < subjectString.length(); i++) {
            if (character == subjectString.charAt(i)) {
                indexCounter++;
            } else {
                break;
            }

        }
        return indexCounter;


    }
}


//abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbffffffffffffffffddfdfsdfdxcvxcvxcvfpkfgkoefjwioefjoijfdsfsdfsjdfsdaddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddfjsdfsdjkfnsdkfnsdfjknsdfknsdfnsdfjksdnfsjkdfnsdfsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdfjnsdfnsjkdfnskdnfqweweweweweweweweweweweweweweweweweweweweweweweewrwerwerrsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdfdfdfdfggggggdfdfdsfsfsf
//abddasadddaaabcccccasas
public class JewelGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());


        IntStream.range(0, t).forEach(tItr -> {
            try {
                String jewels = bufferedReader.readLine();

                long startTime = System.nanoTime();
                int ans = Result1.getMaxScoreStack(jewels);
                System.out.println("ans = " + ans);
                long stopTime = System.nanoTime();
                System.out.println(stopTime - startTime);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }
}
