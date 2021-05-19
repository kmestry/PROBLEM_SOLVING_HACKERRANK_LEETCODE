package com.geeksforgeeks.strings;

public class SanitizeString {

    public static void main(String[] args) {

        SanitizeString sanitizeString = new SanitizeString();
        sanitizeString.sanitizeString("HoW arE yOu");
        //"How are you"
    }

    private String sanitizeString(String input) {

        String lowerCase = input.toLowerCase();

        char[] charArray = lowerCase.toCharArray();

        charArray[0] = Character.toUpperCase(charArray[0]);

        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }
        //  System.out.println("charArray = " + charArray);

        return null;
    }
}
