package com.hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        grades.stream().forEach(grade -> {
            if (grade < 38) {
                result.add(grade);
            } else if (grade % 5 == 0) {
                result.add(grade);
            } else {
                int lastDigitOfGrade = grade % 10;
                int firstDigitOfGrade = grade / 10;
                int nextMultipleOfFive = 0;

                if (lastDigitOfGrade > 0 && lastDigitOfGrade < 5) {
                    nextMultipleOfFive = firstDigitOfGrade * 10 + 5;
                    if (nextMultipleOfFive - grade < 3) {
                        result.add(nextMultipleOfFive);
                    } else {
                        result.add(grade);
                    }

                } else if (lastDigitOfGrade > 5 && lastDigitOfGrade <= 9) {
                    nextMultipleOfFive = (firstDigitOfGrade + 1) * 10;
                    if (nextMultipleOfFive - grade < 3) {
                        result.add(nextMultipleOfFive);
                    } else {
                        result.add(grade);
                    }

                }
            }

        });
        return result;
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);
        System.out.println("result = " + result);


        bufferedReader.close();
    }
}
