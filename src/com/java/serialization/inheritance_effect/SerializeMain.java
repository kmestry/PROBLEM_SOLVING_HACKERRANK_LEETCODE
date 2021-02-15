package com.java.serialization.inheritance_effect;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeMain {
    public static void main(String[] args) throws IOException {


        Employee employee = new Employee("231", "IT", "KUNAL");


        FileOutputStream fileOutputStream = new FileOutputStream("employee.ser1");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
        System.out.println("Successfully serialized!");

        objectOutputStream.close();
        fileOutputStream.close();


    }
}
