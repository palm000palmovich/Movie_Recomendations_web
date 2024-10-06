package com.example.artifact;

public class EmployeeIsNotInTheDataBase extends RuntimeException{
    public EmployeeIsNotInTheDataBase(String message){
        super(message);
    }
}
