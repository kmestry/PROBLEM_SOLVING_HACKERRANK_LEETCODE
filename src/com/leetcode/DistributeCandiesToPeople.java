package com.leetcode;

public class DistributeCandiesToPeople {

    public static void main(String[] args) {
        new DistributeCandiesToPeople().distributeCandies(55, 4);
    }

    /* : candies = 7, num_people = 4
     Output: [1,2,3,1]*/
    public int[] distributeCandies(int candies, int num_people) {


        // first round
        int[] resultCandyArray = new int[num_people];
        boolean isFirstRotationBroken = false;

        int candyCounter = 1;
        for (int i = 0; i < resultCandyArray.length; i++) {

            if (candies == 0) {
                isFirstRotationBroken = true;
                break;
            }


            if (candyCounter > candies) {
                candyCounter = candies;
            }

            resultCandyArray[i] = candyCounter;
            candyCounter++;
            candies = candies - resultCandyArray[i];
        }


        if (!isFirstRotationBroken) {
            //leftover candies after 1st rotation.
            int candiesToLastPerson = num_people;
            int indexCounter = 0;
            int rotationCounter = 1;

            int numPeopleIncrementer = 1;
            while (true) {

                if (indexCounter > resultCandyArray.length - 1) {
                    indexCounter = 0;
                    rotationCounter = 1;
                    numPeopleIncrementer++;
                    candiesToLastPerson = num_people * numPeopleIncrementer;

                }

                int candiesToGive = candiesToLastPerson + rotationCounter;

                if (candies == 0) {
                    break;
                }

                if (candiesToGive > candies) {
                    candiesToGive = candies;
                }


                resultCandyArray[indexCounter] = candiesToGive + resultCandyArray[indexCounter];
                candies -= candiesToGive;

                indexCounter++;
                rotationCounter++;

            }

        }

        return resultCandyArray;
    }
}
