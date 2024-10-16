package com.example.Exceptions;

public class FilmAlreadyAddedException extends RuntimeException{
    public FilmAlreadyAddedException(String message){
        super(message);
    }
}
