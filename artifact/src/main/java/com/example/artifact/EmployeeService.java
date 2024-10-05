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
        Employee newEmpl = new Employee(id , fio, department, salary);
        if (!employees.contains(newEmpl)){employees.add(newEmpl);} else{
            throw new EmployeeAlreadyAddedException("Этот сотрудник уже есть!");}
        return "Сотрудник успешно добавлен!";
    }

    //Все сотрудники
    public String allEmployees() throws DataOfEnployeesIsEmpty{
            if (employees.isEmpty()){
                throw new DataOfEnployeesIsEmpty("База данных пуста!");
            } return employees.toString() + "   ";
    }

    //Удаление сотрудника
    public String removeEmployee(String fio1){
        boolean flag = true;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFio().equals(fio1)){flag = true;}
        }
        if (flag == true){
            List<Employee> updatedEmployees = employees.stream()
                    .filter(e -> !e.getFio().equals(fio1))
                    .collect(Collectors.toList());
            this.employees = updatedEmployees;
            return "Сотрудник удален!";
        }
        throw new EmployeeIsNotInTheDataBase("Такого сотрудника нет!");
    }

}

