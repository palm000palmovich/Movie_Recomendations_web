package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class EmployeeService {
    private final int maxCount = 4;
    private List<Employee> employees = new ArrayList<>();


    //Добавление сотрудников
    public String addEmployee(int id, String firstN, String secondN){
        if (employees.size() < maxCount){
            Employee dude = new Employee(id, firstN, secondN);
            employees.add(dude);
            return "Вы успешно добавили сотрудника!";
        }  return "Места нет!";
    }

    //Вывод сотрудников
    public List<Employee> allEmployee(){
        return employees;
    }
}
