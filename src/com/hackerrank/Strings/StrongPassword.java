package com.hackerrank.Strings;

public class StrongPassword {

    public static final int MINIMUM_PASSWORD_LENGTH = 6;

    // Complete the minimumNumber function below.
    // #HackerRank
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int numberOfChars = 0;

        boolean isLengthOk = isLengthOk(password);
        boolean hasAtleastOneDigit = hasAtleastOneDigit(password);
        boolean hasAtleastOneLowerCaseCharacter = hasAtleastOneLowerCaseCharacter(password);
        boolean hasAtleastOneUpperCaseCharacter = hasAtleastOneUpperCaseCharacter(password);
        boolean hasAtleastOneSpecialCaseCharacter = hasAtleastOneSpecialCaseCharacter(password);


        if (!hasAtleastOneDigit) {
            numberOfChars += 1;
        }
        if (!hasAtleastOneLowerCaseCharacter) {
            numberOfChars += 1;
        }
        if (!hasAtleastOneUpperCaseCharacter) {
            numberOfChars += 1;
        }
        if (!hasAtleastOneSpecialCaseCharacter) {
            numberOfChars += 1;
        }
        if (!isLengthOk && (n + numberOfChars < 6)) {
            numberOfChars += 1;
        }

        if (n + numberOfChars < MINIMUM_PASSWORD_LENGTH) {
            int extraCharsRequired = MINIMUM_PASSWORD_LENGTH - (n + numberOfChars);
            numberOfChars = numberOfChars + extraCharsRequired;

        }
        System.out.println(numberOfChars);
        return numberOfChars;
    }

    static boolean isLengthOk(String password) {
        return password.length() >= 6;
    }

    static boolean hasAtleastOneDigit(String password) {
        String[] charPasswordArray = password.split("");
        for (int i = 0; i < charPasswordArray.length; i++) {
            if (charPasswordArray[i].matches("[0-9]")) {
                return true;
            }
        }
        return false;

    }

    static boolean hasAtleastOneLowerCaseCharacter(String password) {
        String[] charPasswordArray = password.split("");
        for (int i = 0; i < charPasswordArray.length; i++) {
            if (charPasswordArray[i].matches("[a-z]")) {
                return true;
            }
        }
        return false;

    }

    static boolean hasAtleastOneUpperCaseCharacter(String password) {
        String[] charPasswordArray = password.split("");
        for (int i = 0; i < charPasswordArray.length; i++) {
            if (charPasswordArray[i].matches("[A-Z]")) {
                return true;
            }
        }
        return false;

    }

    static boolean hasAtleastOneSpecialCaseCharacter(String password) {
        String[] charPasswordArray = password.split("");
        for (int i = 0; i < charPasswordArray.length; i++) {
            if (charPasswordArray[i].matches("[^A-Za-z0-9]")) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        //  minimumNumber(3, "Ab1");


        //minimumNumber(5, "rZaEu");

        minimumNumber(7, "AUzs-nV");

    }
}
