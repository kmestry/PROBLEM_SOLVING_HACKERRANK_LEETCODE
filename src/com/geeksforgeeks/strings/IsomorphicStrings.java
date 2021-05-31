package com.geeksforgeeks.strings;


public class IsomorphicStrings {

    public static void main(String[] args) {

        boolean result = IsomorphicStrings.areIsomorphic("toayaxz", "fbjbkrx");
        System.out.println(result);
    }

    /*
     String 1:              A B E A C D B
     index pattern:         0 1 2 0 4 5 1
     String 2:              X Y I X H K Y
     index pattern:         0 1 2 0 4 5 1
     */
    public static boolean areIsomorphic(String str1, String str2) {
        // Your code here

        StringBuilder indexPattern1 = new StringBuilder();
        StringBuilder indexPattern2 = new StringBuilder();
        java.util.Map<Character, Integer> characterIndexMap = new java.util.HashMap<>();
        createIndexPatternString(str1, indexPattern1, characterIndexMap);
        characterIndexMap.clear();
        createIndexPatternString(str2, indexPattern2, characterIndexMap);


        return indexPattern1.toString().equals(indexPattern2.toString());

    }

    private static void createIndexPatternString(String str1, StringBuilder indexPattern1,
                                                 java.util.Map<Character, Integer> characterIndexMap) {
        for (int i = 0; i < str1.length(); i++) {
            char key = str1.charAt(i);
            if (characterIndexMap.containsKey(key)) {
                indexPattern1.append(characterIndexMap.get(key));
            } else {
                indexPattern1.append(i);
                characterIndexMap.put(key, i);
            }

        }
    }
}
