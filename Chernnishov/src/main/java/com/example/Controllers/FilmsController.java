package com.example.Controllers;

import com.example.Exceptions.FilmAlreadyAddedException;
import com.example.Exceptions.FilmsArentAddedException;
import com.example.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/movies")
public class FilmsController {
    private final UserService usSer;

    public FilmsController(UserService usSer){
        this.usSer = usSer;
    }

    //Добавление любимого фильма
    @GetMapping(path = "/bestFilm")
    public String bests(@RequestParam("director")String director,
                        @RequestParam("genre") String genre,
                        @RequestParam("year") int year) {
        try {
            return usSer.bestFilms(director, genre, year);
        } catch (FilmAlreadyAddedException e){
            return "Этот фильм уже есть в списке любимых!";
        }
    }

    @GetMapping(path = "/watchLater")
    public String laters(@RequestParam("director")String director,
                        @RequestParam("genre") String genre,
                        @RequestParam("year") int year) {
        try {
            return usSer.watchLaterFilms(director, genre, year);
        } catch (FilmAlreadyAddedException e){
            return "Этот фильм уже есть в списке любимых!";
        }
    }

    //Вывод любимых/смотреть позже фильмов
    @GetMapping(path = "/preferences")
    public String allPreferences(){
        try{
            return usSer.allMovies();
        } catch(FilmsArentAddedException e){
            return "База данных фильмов пуста!";
        }
    }

    //Вывод библиотеки фильмов
    @GetMapping(path = "/allMovies")
    public String library(){
        return usSer.moviesLibrary().toString();
    }
}
