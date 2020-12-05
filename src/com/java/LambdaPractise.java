package com.java;

import java.util.Arrays;
import java.util.List;

public class LambdaPractise {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 100);

        List<String> strings = Arrays.asList("a", "b", "c", "d");

        int res = list.stream().reduce(0, (integer, integer2) -> integer - integer2);
        System.out.println("res = " + res);


        String result = strings.stream().reduce("", (s, s2) -> s.toUpperCase() + s2.toUpperCase());
        System.out.println("result = " + result);


        User user1 = new User("kunal", 29);
        User user2 = new User("abcd", 63);


        List<User> listUser = Arrays.asList(user1, user2);
        int userSum = listUser.stream().reduce(0, (integer, user) -> integer + user.getAge(), Integer::sum);
        System.out.println("userSum = " + userSum);


    }

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }
}
