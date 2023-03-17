package com.supermarket;

public class ItemException extends RuntimeException{

    private String message;

    public ItemException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
