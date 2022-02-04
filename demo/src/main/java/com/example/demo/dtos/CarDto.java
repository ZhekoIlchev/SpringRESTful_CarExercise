package com.example.demo.dtos;

import com.example.demo.models.Engine;
import com.example.demo.models.Owner;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

public class CarDto {


    private EngineDto engineDto;

    private OwnerDto ownerDto;

    @NotEmpty(message = "Please provide brand")
    private String brand;

    @NotEmpty(message = "Please provide model")
    private String model;

    @NotEmpty(message = "Please provide manufacture date")
    private String manufactureDate;

    @NotEmpty(message = "Please provide plate number")
    private String plateNumber;

    public CarDto() {

    }

    public CarDto(EngineDto engineDto, OwnerDto ownerDto, String brand, String model, String manufactureDate, String plateNumber) {
        this.engineDto = engineDto;
        this.ownerDto = ownerDto;
        this.brand = brand;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.plateNumber = plateNumber;
    }

    public EngineDto getEngine() {
        return engineDto;
    }

    public void setEngine(EngineDto engine) {
        this.engineDto = engine;
    }

    public OwnerDto getOwner() {
        return ownerDto;
    }

    public void setOwner(OwnerDto owner) {
        this.ownerDto = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
