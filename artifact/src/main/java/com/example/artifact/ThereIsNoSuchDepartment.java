package com.example.artifact;

public class ThereIsNoSuchDepartment extends RuntimeException{
    public ThereIsNoSuchDepartment(String message){
        super(message);
    }
}
