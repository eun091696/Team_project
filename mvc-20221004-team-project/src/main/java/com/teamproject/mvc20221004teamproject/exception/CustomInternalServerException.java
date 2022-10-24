package com.teamproject.mvc20221004teamproject.exception;

public class CustomInternalServerException  extends RuntimeException{
    public CustomInternalServerException(String message) {
        super(message);
    }
}
