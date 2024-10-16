package com.example.Exceptions;

public class PreferencesAreEmptyException extends RuntimeException{
    public PreferencesAreEmptyException(String message){
        super(message);
    }
}
