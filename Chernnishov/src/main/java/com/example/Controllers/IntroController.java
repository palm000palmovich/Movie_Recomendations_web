package com.example.Controllers;

import com.example.Exceptions.FilmAlreadyAddedException;
import com.example.Exceptions.FilmsArentAddedException;
import com.example.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class IntroController {
    private final UserService start;

    public IntroController(UserService start){
        this.start = start;
    }

    //Стартовый экран приветствия
    @GetMapping(path = "/start")
    //Приветствие
    public String intro(){
        return start.ptintIntro();
    }

}
