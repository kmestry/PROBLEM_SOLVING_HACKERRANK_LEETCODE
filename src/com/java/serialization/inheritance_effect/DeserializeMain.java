package com.java.serialization.inheritance_effect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("employee.ser1");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Employee employee = (Employee) objectInputStream.readObject();

        System.out.println(employee);
    }
}
