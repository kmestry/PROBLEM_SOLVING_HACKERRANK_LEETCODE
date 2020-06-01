package com.hackerrank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DynamicArray {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    /*  1 0 5
        1 1 7
        1 0 3
        2 1 0
        2 1 1
*/
    static int lastAnswer = 0;

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> sequences = new ArrayList(n);
        final int nFinal = n;
        while (n > 0) {
            sequences.add(new ArrayList());
            n = n - 1;
        }

        List<Integer> result = new ArrayList<>();

        queries.forEach(listOfIntegers -> {
            if (listOfIntegers.get(0) == 1) {
                int sequenceNumberOfList = (listOfIntegers.get(1) ^ lastAnswer) % nFinal;
                sequences.get(sequenceNumberOfList).add(listOfIntegers.get(2));


            } else if (listOfIntegers.get(0) == 2) {

                int sequenceNumberOfList = (listOfIntegers.get(1) ^ lastAnswer) % nFinal;
                int seqSize = sequences.get(sequenceNumberOfList).size();
                int indexToFind = listOfIntegers.get(2) % seqSize;
                lastAnswer = sequences.get(sequenceNumberOfList).get(indexToFind);
                System.out.println(lastAnswer);
                result.add(lastAnswer);


            }
        });

        return result;
    }


    public static void main(String[] args) throws IOException {
       /* List<List<Integer>> parentList = new ArrayList<>();
        List<Integer> list0 = Arrays.asList(1, 0, 5);
        List<Integer> list1 = Arrays.asList(1, 1, 7);
        List<Integer> list2 = Arrays.asList(1, 0, 3);
        List<Integer> list3 = Arrays.asList(2, 1, 0);
        List<Integer> list4 = Arrays.asList(2, 1, 1);

        parentList.add(list0);
        parentList.add(list1);
        parentList.add(list2);
        parentList.add(list3);
        parentList.add(list4);


        dynamicArray(2, parentList);*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = DynamicArray.dynamicArray(n, queries);


    }

}
