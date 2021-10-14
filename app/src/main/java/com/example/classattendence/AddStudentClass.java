package com.example.classattendence;

public class AddStudentClass {
    String roll;
    String name;
    String Status;

    public AddStudentClass(String roll, String name) {
        this.roll = roll;
        this.name = name;
        Status="";
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
