package com.java.serialization.inheritance_effect;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 10L;
    String empId;
    String empDept;

    public Employee(String empId, String empDept, String name) {
        super(name);
        this.empDept = empDept;
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empDept='" + empDept + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
