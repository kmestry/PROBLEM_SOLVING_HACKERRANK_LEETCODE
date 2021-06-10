package com.hackerrank.interview_companies_1;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * Create the Filter and Mapper classes here.
 */
class CharactersCount {


    private final String name;
    private final Integer distinctCharacterCount;

    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }

    public String getName() {
        return name;
    }

    public Integer getDistinctCharacterCount() {
        return distinctCharacterCount;
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}

class Filter {

    public static Predicate<? super String> nameStartingWithPrefix(String prefix) {
        return (str) -> str.startsWith(prefix);

    }
}

class Mapper {

  /*  Function<Integer, String> getMyFunction() {
        return (it) -> "Hello, world: " + it;
    }*/

    public static Function<String, CharactersCount> getDistinctCharactersCount() {
        return (str) -> {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            return new CharactersCount(null, set.size());
        };
    }
}

class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );

        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                .map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out::println);
    }
}