package com.example.Egg_Store.exception;

public class EggTypeNotFoundException extends RuntimeException{

    public EggTypeNotFoundException(String message){
        super(message);
    }
}
