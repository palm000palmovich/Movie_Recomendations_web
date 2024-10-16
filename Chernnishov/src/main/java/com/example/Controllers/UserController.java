package com.example.Controllers;

import com.example.Exceptions.PreferencesAreEmptyException;
import com.example.Exceptions.UserIsEmptyException;
import com.example.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService user;

    public UserController(UserService user){
        this.user = user;
    }

    //Запись пользователя
    @GetMapping(path = "/writeUser")
    public String wrUs(@RequestParam("age") int age){
        return user.writeUser(age);
    }

    //Вывод пользователя
    @GetMapping(path = "/printUser")
    public String printUs(){
        return user.printUser();
    }

}
