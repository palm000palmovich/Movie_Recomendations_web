package com.example.artifact;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    //Добавление сотрудника
    public String addEmployee(int id, String fio, int department, int salary) throws EmployeeAlreadyAddedException{
        String key = fio;
        employees = employees.stream()
                .filter(e -> !e.getFio().equals(key))
                .collect(Collectors.toList());
        return "Сотрудник добавлен";
    }

    //Все сотрудники
    public String allEmployees() throws DataOfEnployeesIsEmpty{
            if (employees.isEmpty()){
                throw new DataOfEnployeesIsEmpty("База данных пуста!");
            }
            return employees.stream()
                    .collect(Collectors.joining(", "));
        }

}

