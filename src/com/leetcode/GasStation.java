package com.leetcode;

public class GasStation {


    public static void main(String[] args) {
        //new GasStation().canCompleteCircuitBruteForce(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});

        new GasStation().canCompleteCircuitBruteForce(new int[]{2, 3, 4}, new int[]{3, 4, 3});
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0, filled = 0, required = 0;
        for (int i = 0; i < gas.length; i++) {
            filled += gas[i] - cost[i];
            if (filled < 0) {
                required += filled;
                ans = i + 1;
                filled = 0;
            }
        }
        return filled >= Math.abs(required) ? ans : -1;
    }


    // 1 2 3 4 5
    // 3 4 5 1 2

    // 2 3 4
    // 3 4 3
    public int canCompleteCircuitBruteForce(int[] gas, int[] cost) {


        int gasInTank = 0;

        int startIndex = 0;  // this variable holds the result if the index is found.
        int visited = 0;  //maintains the count of the elements visited to find the candidate element according to problem.
        int countOfNodesVisited = 0;  //this holds the number of nodes visited from a particular index.
        while (visited < cost.length) { //check till we have verified all the elements.
            for (int i = startIndex; i <= gas.length; i++) {

                //if at some time we have countOfNodesVisited equal to
                // the array length we return the startIndex i.e. we found valid
                //index which can complete the cirlce.
                if (countOfNodesVisited == gas.length) {
                    return startIndex;
                }
                //this condition is to start the loop from beginning to check
                //if the current index can form a complete circular path in
                //array.
                if (i == gas.length) {
                    //check if countOfNodesVisited from the particular index i.e. startIndex
                    //is less than gas.length, if true start from beginning of array.
                    //THIS IS TO CHECK ALL THE ELEMENTS IN CIRCULAR MANNER IN ARRAY>
                    if (countOfNodesVisited < gas.length) {
                        i = -1;
                    }
                } else {
                    gasInTank += gas[i];  // count the gas in tank using gas array .
                    int costToReachNextDestination = cost[i]; //count the gas required to reach next index or destination in array
                    if (costToReachNextDestination > gasInTank) {
                        //if the costToReachNextDestination > gas in tank till now.. it means we cannot reach the next index.
                        //check the next index if it satisfies given condition.
                        startIndex = i + 1;
                        visited++;  //mark the index as visited
                        countOfNodesVisited = 0; //reset the number of elements visited.
                        //this count is required to check the when the correct index is found.
                        //and we have visited all the nodes in the circular array.
                        gasInTank = 0; //reset the count to zero once again.
                        break;
                    } else {
                        countOfNodesVisited++; //increase nodes visited count.
                        gasInTank = gasInTank - costToReachNextDestination; // check how much gas is remaining
                        //after using the costToReachNextDestination
                    }
                }

            }
        }


        return -1;
    }
}
