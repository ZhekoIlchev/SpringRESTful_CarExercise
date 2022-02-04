package com.example.demo.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "engine")
@Table(name = "engines", uniqueConstraints = @UniqueConstraint(columnNames = {"engine_number"}))
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "engine_number", unique = true)
    @NotNull(message = "The engine can not be null")
    @NotEmpty(message = "Please provide an engine number")
    private String engineNumber;

    @NotNull(message = "The volume can not be null")
    private Double volume;

    @NotNull(message = "Please provide horse power")
    private Integer horsePower;

    public Engine() {

    }

    public Engine(String engineNumber, Double volume, Integer horsePower) {
        this.engineNumber = engineNumber;
        this.volume = volume;
        this.horsePower = horsePower;
    }

    public Engine(Long id, String engineNumber, Double volume, Integer horsePower) {
        this.id = id;
        this.engineNumber = engineNumber;
        this.volume = volume;
        this.horsePower = horsePower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Engine{" +
                "id=" + id +
                ", engineNumber='" + engineNumber + '\'' +
                ", volume=" + volume +
                ", horsePower=" + horsePower +
                '}';
    }
}
