package com.hackerrank.interview_companies_1.oops;

class Account implements OnlineAccount, Comparable<Account> {

    String ownerName;
    int noOfRegularMovies, noOfExclusiveMovies;

    public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
        this.ownerName = ownerName;
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
    }


    // 1) Add a parameterized constructor
    // that initializes the attributes noOfRegularMovies and noOfExclusiveMovies.


    // 2. This method returns the monthly cost for the account.
    public int monthlyCost() {
        int regularPriceFactor = noOfRegularMovies * regularMoviePrice;
        int exclusivePriceFactor = noOfExclusiveMovies * exclusiveMoviePrice;

        return basePrice + regularPriceFactor + exclusivePriceFactor;
    }

    // 3. Override the compareTo method of the Comparable interface such that two accounts can be compared based on their monthly cost.

    // 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
    public String toString() {
        String prefix = "Owner is ";
        String midString = " and monthly cost is ";
        String suffix = " USD.";

        String sb = prefix + ownerName +
                midString + monthlyCost() + suffix;
        return sb;
    }

    @Override
    public int compareTo(Account o) {
        return this.monthlyCost() - o.monthlyCost();
    }
}