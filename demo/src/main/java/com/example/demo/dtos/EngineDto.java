package com.example.demo.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EngineDto {

    @Size(min = 5, message = "Not a engine number")
    @NotNull(message = "The engine can not be null")
    @NotEmpty(message = "Please provide an engine number")
    private String engineNumber;

    @NotNull(message = "The volume can not be null")
    private Double volume;

    @NotNull(message = "Please provide horse power")
    private Integer horsePower;

    public EngineDto() {

    }

    public EngineDto(String engineNumber, Double volume, Integer horsePower) {
        this.engineNumber = engineNumber;
        this.volume = volume;
        this.horsePower = horsePower;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "EngineDto{" +
                "engineNumber='" + engineNumber + '\'' +
                ", volume=" + volume +
                ", horsePower=" + horsePower +
                '}';
    }
}
