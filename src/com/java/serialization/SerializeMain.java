package com.java.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeMain {

    public static void main(String[] args) {

        try {

            Address address = new Address("Mumbai", "Maharashtra", "Mira Road");

            Employee employee = new Employee("Robert", 1, "IT", address);
            // Employee employee1 = new Employee("John" , 2 , "ACCOUNTS");
            FileOutputStream fileOutputStream = new FileOutputStream("employee.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Successfully serialized");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
