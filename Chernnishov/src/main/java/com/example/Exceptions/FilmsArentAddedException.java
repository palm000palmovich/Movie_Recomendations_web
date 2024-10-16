package com.example.Exceptions;

public class FilmsArentAddedException extends  RuntimeException{
    public FilmsArentAddedException(String message){
        super(message);
    }

}
