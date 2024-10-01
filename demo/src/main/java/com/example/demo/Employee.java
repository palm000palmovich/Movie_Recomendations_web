package com.example.demo;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String SecondName;

    public Employee(int id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        SecondName = secondName;
    }


    //Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    //Геттеры
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(SecondName, employee.SecondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, SecondName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                '}';
    }


}

