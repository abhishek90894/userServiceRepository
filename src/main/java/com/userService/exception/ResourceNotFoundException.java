package com.userService.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("userId not found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
