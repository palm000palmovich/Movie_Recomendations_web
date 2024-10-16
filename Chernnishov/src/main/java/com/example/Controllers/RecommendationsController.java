package com.example.Controllers;

import com.example.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class RecommendationsController {

    private final UserService us;

    public RecommendationsController(UserService us){
        this.us = us;
    }

    @GetMapping(path = "/recomendations")
    public String printRecs(){
        return us.recommendations().toString();
    }

}
