package com.example.Egg_Store.exception;

public class InvalidEggTypeException extends RuntimeException{

    public InvalidEggTypeException(String message){
        super(message);
    }
}
