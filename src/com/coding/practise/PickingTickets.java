package com.coding.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingTickets {

    public static void main(String[] args) {

        // int result = PickingTickets.maxTickets(Arrays.asList(8, 5, 4, 8, 4));
        int result = PickingTickets.maxTickets(Arrays.asList(4, 13, 2, 3));
        System.out.println("result = " + result);
    }

    // Complete the maxTickets function below.
    static int maxTickets(List<Integer> tickets) {


        int maxTicket = Integer.MIN_VALUE;

        Collections.sort(tickets);
        //Rule
        int numOfElementsFollowingRule = 1;
        for (int i = 0; i < tickets.size() - 1; i++) {
            int absDifference = Math.abs(tickets.get(i) - tickets.get(i + 1));
            if (absDifference == 0 || absDifference == 1) {
                numOfElementsFollowingRule++;
            } else {
                maxTicket = Math.max(numOfElementsFollowingRule, maxTicket);
                numOfElementsFollowingRule = 1;
            }
        }
        return maxTicket;

    }

    /*public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int ticketsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ticketsTemp = new ArrayList<>();

        IntStream.range(0, ticketsCount).forEach(i -> {
            try {
                ticketsTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> tickets = ticketsTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int res = maxTickets(tickets);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }*/
}
