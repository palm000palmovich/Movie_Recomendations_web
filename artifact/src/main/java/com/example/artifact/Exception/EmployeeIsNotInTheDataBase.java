package com.example.artifact.Exception;

public class EmployeeIsNotInTheDataBase extends RuntimeException{
    public EmployeeIsNotInTheDataBase(String message){
        super(message);
    }
}
