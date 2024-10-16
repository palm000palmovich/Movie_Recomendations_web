package com.example.Exceptions;

public class IncorrectDirectorException extends RuntimeException{
    public IncorrectDirectorException(String message){
        super(message);
    }
}
