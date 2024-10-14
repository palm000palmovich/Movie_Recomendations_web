package com.example.artifact.Classes;

import com.example.artifact.Exception.DataOfEnployeesIsEmpty;
import com.example.artifact.Exception.EmployeeAlreadyAddedException;
import com.example.artifact.Exception.EmployeeIsNotInTheDataBase;
import com.example.artifact.Exception.ThereIsNoSuchDepartment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService{
    private List<Employee> employees = new ArrayList<>();

    //Добавление сотрудника
    public String addEmployee(int id, String fio, int department, int salary) throws EmployeeAlreadyAddedException {
        if (StringUtils.isNotEmpty(fio) && !fio.chars().anyMatch(Character::isDigit)){   //Если строка непустая и не имеет в записи цифры
            String fio1 = StringUtils. capitalize(fio);  //Все ФИО начинаются с заглавной буквы


            Employee newEmpl = new Employee(id, fio1, department, salary);
            if (!employees.contains(newEmpl)){employees.add(newEmpl);} else{
                throw new EmployeeAlreadyAddedException("Этот сотрудник уже есть!");}
            return "Сотрудник успешно добавлен!";
        } else{
            throw new WrongFioException("Некорректная запись ФИО!");
        }
    }

    //Все сотрудники
    public List<Employee> allEmployees() throws DataOfEnployeesIsEmpty {
            if (employees.isEmpty()){
                throw new DataOfEnployeesIsEmpty("База данных пуста!");
            }
        List<Employee> employeesPureDepartment = employees.stream()
                .flatMap(emp1 -> employees.stream()
                        .filter(emp2 -> emp1.getDepartment() == emp2.getDepartment())
                        .distinct())
                .collect(Collectors.toList());



        return employeesPureDepartment;
    }

    //Удаление сотрудника
    public String removeEmployee(String fio1){
        if (StringUtils.isNotEmpty(fio1) && !fio1.chars().anyMatch(Character::isDigit)) {   //Если строка непустая и не имеет в записи цифры
            String fio2 = StringUtils. capitalize(fio1);  //Все ФИО начинаются с заглавной буквы
            boolean flag = employees.stream()
                    .anyMatch(employee -> employee.getFio().equals(fio2));

            if (flag == true) {
                List<Employee> updatedEmployees = employees.stream()
                        .filter(e -> !e.getFio().equals(fio2))
                        .collect(Collectors.toList());
                this.employees = updatedEmployees;
                return "Сотрудник удален!";
            }
            throw new EmployeeIsNotInTheDataBase("Такого сотрудника нет!");
        }else{
            throw new WrongFioException("Некорректная запись ФИО!");
        }
    }

    //Сотрудники по номеру отдела
    public String employeesInDepartment(String depId) throws ThereIsNoSuchDepartment, DataOfEnployeesIsEmpty{
        if (employees.isEmpty()){throw new DataOfEnployeesIsEmpty("База данных пуста!");}
        int dep = Integer.parseInt(depId);
        boolean flag = employees.stream()
                .anyMatch(employee -> employee.getId() == dep);

        if (flag == false){throw new ThereIsNoSuchDepartment("Такого отдела нет!");}
        List<Employee> emplsInDep = employees.stream()
                .filter(empl -> empl.getDepartment() == dep)
                .collect(Collectors.toList());
        return "Сотрудники " + dep + " -го отдела: " + emplsInDep.toString();
    }

    //Сотрудник с минимальной зп в отделе
    public Optional<Employee> minSalaryInDep(int depId) throws ThereIsNoSuchDepartment, DataOfEnployeesIsEmpty{
        boolean flag = employees.stream()
                .anyMatch(employee -> employee.getDepartment() == depId);

        if (flag == false){throw new ThereIsNoSuchDepartment("Такого отдела нет!");}
        if (employees.isEmpty()){
            throw new DataOfEnployeesIsEmpty("База сотрудников пуста!");
        }
        Optional<Employee> minSalEmpl = employees.stream()
                .filter(emp -> emp.getDepartment() == depId)
                .min(Comparator.comparingDouble(Employee::getSalary));
        return minSalEmpl;
    }

    //Сотрудник с максимальной зп в отделе
    public Optional<Employee> maxSalInDep(int depId){
        boolean flag = employees.stream()
                .anyMatch(employee -> employee.getDepartment() == depId);

        if (flag == false){throw new ThereIsNoSuchDepartment("Такого отдела нет!");}
        if (employees.isEmpty()){
            throw new DataOfEnployeesIsEmpty("База сотрудников пуста!");
        }
        Optional<Employee> minSalEmpl = employees.stream()
                .filter(emp -> emp.getDepartment() == depId)
                .max(Comparator.comparingDouble(Employee::getSalary));
        return minSalEmpl;
    }
}

