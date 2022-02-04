package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cars", uniqueConstraints = {@UniqueConstraint(columnNames = {"engine_id"})})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Engine.class)
    @JoinColumn(name = "engine_id", referencedColumnName = "id", unique = true)
    private Engine engine;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Owner.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    @NotEmpty(message = "Please provide brand")
    private String brand;

    @NotEmpty(message = "Please provide model")
    private String model;

    @NotEmpty(message = "Please provide manufacture date")
    private String manufactureDate;

    @NotEmpty(message = "Please provide plate number")
    private String plateNumber;

    public Car() {

    }

    public Car(Engine engine, Owner owner, String brand, String model, String manufactureDate, String plateNumber) {
        this.engine = engine;
        this.owner = owner;
        this.brand = brand;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.plateNumber = plateNumber;
    }

    public Car(Long id, Engine engine, Owner owner, String brand, String model, String manufactureDate, String plateNumber) {
        this.id = id;
        this.engine = engine;
        this.owner = owner;
        this.brand = brand;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.plateNumber = plateNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", engine=" + engine +
                ", owner=" + owner +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
