package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class EmployeeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeWebApplication.class, args);


		Employee dude  = new Employee(1, "her", "herov");
		Employee dude1  = new Employee(2, "heroo", "herovvvv");
		Employee dude2 = new Employee(3, "njisfj", "dnjfidj");
		Map<String, Employee> maps = new HashMap<>();
		maps.put(dude.getFirstName() + " "  + dude.getSecondName(), dude);
		maps.put(dude1.getFirstName() + " " + dude1.getSecondName(), dude1);
		maps.put(dude2.getFirstName() + " " + dude2.getSecondName(), dude2);
		if (maps.containsKey(dude2.getFirstName() + " " + dude2.getSecondName())){
			System.out.println("Есть такой!");
		} else{
			System.out.println("Нет такого!");
		}
		//Итератор
		Iterator<Employee> iter = maps.values().iterator();
		while (iter.hasNext()) {
			Employee chel = iter.next();
			System.out.println(chel);
		}
	}

}

