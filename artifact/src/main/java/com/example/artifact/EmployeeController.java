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
        return emSer.addEmployee(id, fio, department, salary).toString();
    }
}
