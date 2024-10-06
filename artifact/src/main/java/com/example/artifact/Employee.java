package com.example.artifact;

import java.util.Objects;

public class Employee {
    public static int counter = 1;
    private int id;
    private String fio;
    private int department;
    private int salary;

    //Конструктор
    public Employee(int id, String fio, int department, int salary) {
        this.id = id;
        this.fio = fio;
        this.department = department;
        this.salary = salary;
    }

    //Геттеры

    public String getFio() {
        return fio;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return this.salary;
    }



    public int getId(){return id;}

    //Сеттеры
    public void setDepartment(int department1){
        if (1 > department1 || 5 < department1){
            throw new IllegalArgumentException("Недопустимое значение отдела!");
        } else{
            this.department = department1;
        }
    }
    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        } else {
            this.salary = salary;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && salary == employee.salary && Objects.equals(fio, employee.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, department, salary);
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", fio= " + fio +
                ", department= " + department +
                ", salary= " + salary + "       ";
    }

}
