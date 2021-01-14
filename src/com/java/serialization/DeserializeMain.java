package com.java.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeMain {

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("employee.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Employee emp = (Employee) objectInputStream.readObject();
            System.out.println(emp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
