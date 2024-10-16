package com.example.Exceptions;

public class UserIsEmptyException extends RuntimeException{
    public UserIsEmptyException(String message){
        super(message);
    }

}