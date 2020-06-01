package com.hackerrank.day3;

public class StairCase {

         /*    #
              ##
             ###
            ####
           #####
          ######
    */
    /* logic  check how many times space is to be printed on the first line and how many times hash is to be printed
       as in this case space is printed n-i times and hash(#) is printed i times i.e. according to the loop
    * */

    // Complete the staircase function below.
    static void staircase(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("#");

            }

            System.out.println();


        }

    }


    public static void main(String[] args) {
        staircase(3);
    }
}
