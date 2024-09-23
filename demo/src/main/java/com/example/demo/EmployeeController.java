package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService empl;

    //Конструктор
    public EmployeeController(EmployeeService empl){
        this.empl = empl;
    }

    //Обработка запроса на добавление
    @GetMapping(path = "/add")
    public String add(@RequestParam("id") int id,
                      @RequestParam("firstName") String firstN,
                      @RequestParam("secondName") String secondN){
        try{
            return empl.addEmployee(id,firstN, secondN);
        } catch(EmployeeAlreadyAddedException e){
            return "Этот сотрудник уже есть в базе!";
        } catch (EmployeeStorageIsFullException c){
            return "Место для сотрудников закончилось!";
        }
    }

    //Обработка запроса на вывод сотрудников
    @GetMapping(path = "/find")
    public Employee find(@RequestParam("id") int id){
        return empl.findEmployee(id);
    }

    //Вывод всех сотрудников
    @GetMapping(path = "/all")
    public List<Employee> allEmpl(){
        List<Employee> exception = new ArrayList<>();
        Employee exep = new Employee(0, "Data base", "Is empty!");
        for (int i = 0; i <= 500; i++){
            exception.add(exep);
        }
        try{
            return empl.allEmployees();
        } catch (DataBaseOfEmployeesIsEmpty e){
            return exception;
        }

    }

}
