package com.java.java8_Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStream {


    public static void main(String[] args) {
        List<Employee> employeesList = getListOfEmployees();

        List<String> listCities = employeesList.stream().flatMap(employee -> employee.getListOfCities().stream())
                .collect(Collectors.toList());

        listCities.forEach(System.out::println);


        int sum = employeesList.stream().mapToInt(value -> value.age).
                reduce(0, Integer::sum);


        System.out.println("sum = " + sum);

        employeesList.stream().
                reduce((employee, employee2) -> employee.getAge() < employee2.age ? employee : employee2)
                .ifPresent(System.out::println);

        employeesList.stream().min(Comparator.comparingInt(Employee::getAge)).ifPresent(System.out::println);
    }

    public static List<Employee> getListOfEmployees() {

        List<Employee> listOfEmployees = new ArrayList<>();

        Employee e1 = new Employee("Mohan", 24, Arrays.asList("Newyork", "Banglore"));
        Employee e2 = new Employee("John", 27, Arrays.asList("Paris", "London"));
        Employee e3 = new Employee("Vaibhav", 32, Arrays.asList("Pune", "Seattle"));
        Employee e4 = new Employee("Amit", 22, Arrays.asList("Chennai", "Hyderabad"));

        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);

        return listOfEmployees;
    }
}
