package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class EmployeeService {
    private final int maxCount = 4;
    private List<Employee> employees = new ArrayList<>();


    //Добавление сотрудников
    public String addEmployee(int id, String firstN, String secondN) throws EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException {
        Employee dude = new Employee(id, firstN, secondN);
        if (employees.size() < maxCount) {
            if (!employees.contains(dude)) {
                employees.add(dude);
                return "Вы успешно добавили сотрудника!";
            } else {
                throw new EmployeeAlreadyAddedException("Сотрудник уже есть");
            }
        } else {
            throw new EmployeeStorageIsFullException("Не хватает места!");
        }
    }

    //Поиск сотрудников
    public Employee findEmployee(int id) {
        Employee chel = new Employee(0,null,null);
        for (int i = 0; i <= employees.size(); i++){
            if (employees.get(i).getId() == id){
                chel = employees.get(i);
                return chel;
            }
        } return chel;

    }


    //Все сотрудники
    public List<Employee> allEmployees() {
        if (employees.size() != 0){
            return employees;
        }else {
            throw new DataBaseOfEmployeesIsEmpty("База данных пуста!");
        }

    }
}
