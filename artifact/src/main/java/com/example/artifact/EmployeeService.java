package com.example.artifact;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService{
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
            }
            String employeesPureDepartment = "";
            for (int i = 0; i < employees.size(); i++){
                for (int j = i; j < employees.size(); j++){
                    if (employees.get(i).getDepartment() == employees.get(j).getDepartment()){
                        employeesPureDepartment+= "Отдел номер " + employees.get(j).getDepartment() + " " + employees.get(j);
                    }
                }
                employeesPureDepartment+="\t\t\t";
            }
            return employeesPureDepartment;
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

    //Сотрудники по номеру отдела
    public String employeesInDepartment(String depId) throws ThereIsNoSuchDepartment, DataOfEnployeesIsEmpty{
        if (employees.isEmpty()){throw new DataOfEnployeesIsEmpty("База данных пуста!");}
        int dep = Integer.parseInt(depId);
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == dep){
                flag = true;
            }
        }
        if (flag == false){throw new ThereIsNoSuchDepartment("Такого отдела нет!");}
        List<Employee> emplsInDep = employees.stream()
                .filter(empl -> empl.getDepartment() == dep)
                .collect(Collectors.toList());
        return "Сотрудники " + dep + " -го отдела: " + emplsInDep.toString();
    }

    //Сотрудник с минимальной зп в отделе
    public String minSalaryInDep(int depId) throws ThereIsNoSuchDepartment, DataOfEnployeesIsEmpty{
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == depId){
                flag = true;
            }
        }
        if (flag == false){throw new ThereIsNoSuchDepartment("Такого отдела нет!");}
        if (employees.isEmpty()){
            throw new DataOfEnployeesIsEmpty("База сотрудников пуста!");
        }
        Optional<Employee> minSalEmpl = employees.stream()
                .filter(emp -> emp.getDepartment() == depId)
                .min(Comparator.comparingDouble(Employee::getSalary));
        return minSalEmpl.toString();
    }

    //Сотрудник с максимальной зп в отделе
    public String maxSalInDep(int depId){
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment() == depId){
                flag = true;
            }
        }
        if (flag == false){throw new ThereIsNoSuchDepartment("Такого отдела нет!");}
        if (employees.isEmpty()){
            throw new DataOfEnployeesIsEmpty("База сотрудников пуста!");
        }
        Optional<Employee> minSalEmpl = employees.stream()
                .filter(emp -> emp.getDepartment() == depId)
                .max(Comparator.comparingDouble(Employee::getSalary));
        return minSalEmpl.toString();
    }
}

