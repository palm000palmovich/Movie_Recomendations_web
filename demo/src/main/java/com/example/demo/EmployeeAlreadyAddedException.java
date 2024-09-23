package com.example.demo;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message){
        super(message);
    }

}
