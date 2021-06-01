package com.geeksforgeeks.strings;

public class CheckIfTwoStringsIsRotatedByTwoPlaces {

    public static void main(String[] args) {
        CheckIfTwoStringsIsRotatedByTwoPlaces checkIfTwoStringsIsRotatedByTwoPlaces = new CheckIfTwoStringsIsRotatedByTwoPlaces();
        boolean result = checkIfTwoStringsIsRotatedByTwoPlaces.isRotated("b", "b");


        /*
        *
        * fsbcnuvqhffbsaqxwp
wpfsbcnuvqhffbsaqx
        * */
        System.out.println(result);
    }

    public boolean isRotated(String str1, String str2) {
        // Your code here


        if (str1.length() == 1) return str1.equals(str2); // imp corner case/
        if (str1.length() != str2.length()) return false;
        if (str1.length() == 2) return true;
        if (str1.equals(str2) && str1.length() > 2) return false;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            sb1.append(str1.charAt(i));
        }

        if (str2.substring(str2.length() - 2).equals(sb1.toString())) {
            return true;
        } else {
            for (int i = str1.length() - 2; i < str1.length(); i++) {
                sb2.append(str1.charAt(i));
            }
            return str2.substring(0, 2).equals(sb2.toString());
        }

    }
}



