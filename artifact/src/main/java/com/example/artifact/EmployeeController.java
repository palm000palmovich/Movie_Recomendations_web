package com.example.artifact;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService emSer;

    public EmployeeController(EmployeeService emSer){
        this.emSer = emSer;
    }


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

    @GetMapping(path = "/all")
    public String all(){
        try {
            return emSer.allEmployees();
        } catch (DataOfEnployeesIsEmpty e){
            return "База данных пуста!";
        }
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("fio") String fio){
        try{
            return emSer.removeEmployee(fio);
        } catch (EmployeeIsNotInTheDataBase e){
            return "Такого сотрудника нет в базе данных!";
        }
    }

}
