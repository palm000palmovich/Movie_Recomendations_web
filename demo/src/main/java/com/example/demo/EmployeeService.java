package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeService {
    private final int maxCount = 4;
    //private List<Employee> employees = new ArrayList<>();
    private Map<String, Employee> employees = new HashMap<>();


    //Добавление сотрудников
    public String addEmployee(int id, String firstN, String secondN) throws EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException {
        Employee dude = new Employee(id, firstN, secondN);
        String key = firstN + " " + secondN;

        if (employees.size() < maxCount) {
            if (!employees.containsKey(key)) {
                employees.put(key, dude);
                return "Вы успешно добавили сотрудника!";
            } else {
                throw new EmployeeAlreadyAddedException("Сотрудник уже есть");
            }
        } else {
            throw new EmployeeStorageIsFullException("Не хватает места!");
        }
    }

    //Поиск сотрудников
    public Employee findEmployee(int id, String firstN, String secondN) throws EmployeeNotFoundException{
        Employee chel = new Employee(id, firstN, secondN);
        String key = firstN + " " + secondN;
        if (employees.containsKey(key)) {
            return chel;
        } else{
            throw new EmployeeNotFoundException("Нет такого пользователя!");
        }
    }



    //Все сотрудники
    public List<Employee> allEmployees() {
        List<Employee> chels = new ArrayList<>();

        Iterator<Employee> iter = employees.values().iterator(); //Итератор

        if (employees.size() != 0) {
            while (iter.hasNext()){
                Employee tipok = iter.next();
                chels.add(tipok);
            } return chels;
        } else {
            throw new DataBaseOfEmployeesIsEmpty("База данных пуста!");
        }

    }

    //удаление сотрудника
    public String removeEmployee(int id, String firstN, String secondN) throws EmployeeNotFoundException {
        String key = firstN + " " + secondN;
        if (employees.containsKey(key)){
            employees.remove(key);
            return "Сотрудник успешно удален!";
        } else{
            throw new EmployeeNotFoundException("Такого сотрудника нет в базе.");
        }

    }

}
