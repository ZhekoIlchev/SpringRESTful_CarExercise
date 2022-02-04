package com.example.demo.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(Long id) {
        super("Car id not found.");
    }
}
