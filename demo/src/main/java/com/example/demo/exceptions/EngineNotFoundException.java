package com.example.demo.exceptions;

public class EngineNotFoundException extends RuntimeException {

    public EngineNotFoundException(Long id) {
        super("Engine id not found" + id);
    }
}
