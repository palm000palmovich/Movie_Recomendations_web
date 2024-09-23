package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return empl.addEmployee(id,firstN, secondN);
    }

    //Обработка запроса на вывод сотрудников
    @GetMapping(path = "/find")
    public List<Employee> output(){
        return empl.allEmployee();
    }
}
