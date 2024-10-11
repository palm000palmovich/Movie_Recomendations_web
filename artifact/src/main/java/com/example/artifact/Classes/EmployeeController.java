package com.example.artifact.Classes;

import com.example.artifact.Exception.DataOfEnployeesIsEmpty;
import com.example.artifact.Exception.EmployeeAlreadyAddedException;
import com.example.artifact.Exception.EmployeeIsNotInTheDataBase;
import com.example.artifact.Exception.ThereIsNoSuchDepartment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService emSer;

    public EmployeeController(EmployeeService emSer){
        this.emSer = emSer;
    }
    //Добавление сотрудника
    @GetMapping(path = "/add")
    public String add(@RequestParam("id") int id,
                      @RequestParam("fio") String fio,
                      @RequestParam("department") int department,
                      @RequestParam("salary") int salary){
        try {
            return emSer.addEmployee(id, fio, department, salary).toString();
        } catch (EmployeeAlreadyAddedException e){
            return "Этот сотрудник уже добавлен!";
        }
    }

    //Все сотудники
    @GetMapping(path = "/all")
    public String all() {
        try {
            return emSer.allEmployees().toString();
        } catch (DataOfEnployeesIsEmpty e) {
            return "База данных пуста!";
        }
    }
    //Сотрудники по отделу
    @GetMapping(path = "/allDep")
    public String allDep(@RequestParam("departmentId") String depId){
        try{
            return emSer.employeesInDepartment(depId);
        } catch (ThereIsNoSuchDepartment e){
            return "Сотрудника с таким отделом нет!";
        } catch (DataOfEnployeesIsEmpty e){
            return "База сотрудников пуста!";
        }
    }
    //Удаление сотрудника
    @GetMapping(path = "/remove")
    public String remove(@RequestParam("fio") String fio){
        try{
            return emSer.removeEmployee(fio);
        } catch (EmployeeIsNotInTheDataBase e){
            return "Такого сотрудника нет в базе данных!";
        }
    }

    //Минимальная зп в отделе
    @GetMapping(path = "/min-salary")
    public String minSal(@RequestParam("departmentId") int depId){
        try{
            return emSer.minSalaryInDep(depId).toString();
        } catch (DataOfEnployeesIsEmpty e){
            return "База сотрудников пуста!";
        } catch (ThereIsNoSuchDepartment e){
            return "Нет такого отдела!";
        }
    }

    //Максимальная зп в отделе
    @GetMapping(path = "/max-salary")
    public String maxSal(@RequestParam("departmentId") int depId){
        try{
            return emSer.maxSalInDep(depId).toString();
        } catch (DataOfEnployeesIsEmpty e){
            return "База сотрудников пуста!";
        } catch (ThereIsNoSuchDepartment e){
            return "Нет такого отдела!";
        }
    }
}
