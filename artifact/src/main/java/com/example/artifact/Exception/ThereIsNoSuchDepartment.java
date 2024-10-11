package com.example.artifact.Exception;

public class ThereIsNoSuchDepartment extends RuntimeException{
    public ThereIsNoSuchDepartment(String message){
        super(message);
    }
}
