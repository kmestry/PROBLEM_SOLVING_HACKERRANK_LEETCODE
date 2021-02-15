package com.java.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 2L;
    String empName;
    int empId;
    String empDept;
    transient Address address;

    public Employee(String empName, int empId, String empDept, Address address) {
        this.empName = empName;
        this.empId = empId;
        this.empDept = empDept;
        this.address = address;
    }


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", empDept='" + empDept + '\'' +
                ", city=" + address.city +
                ", state=" + address.state +
                ", street=" + address.street +
                '}';
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(address.getCity());
        objectOutputStream.writeObject(address.getState());
        objectOutputStream.writeObject(address.getStreet());
        // objectOutputStream.close();

    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String city = (String) objectInputStream.readObject();
        String state = (String) objectInputStream.readObject();
        String street = (String) objectInputStream.readObject();
        address = new Address(city, state, street);
    }


}
