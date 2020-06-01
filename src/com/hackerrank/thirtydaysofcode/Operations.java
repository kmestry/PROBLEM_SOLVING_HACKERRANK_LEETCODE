package com.hackerrank.thirtydaysofcode;

public class Operations {

    // Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {


        double tip = tip_percent;
        double tax = tax_percent;
        double tip_percent_ = Double.valueOf(tip / 100) * meal_cost;
        double tax_percent_ = Double.valueOf(tax / 100) * meal_cost;

        double total_meal_cost = meal_cost + Math.round(tip_percent_) + Math.round(tax_percent_);
        System.out.println((int) total_meal_cost);

    }


    /*
    *     12.00

    20

    8
    *
    *
    *     10.25

    17

    5
    * */

    public static void main(String[] args) {
        solve(10.25, 17, 5);
    }
}
