package com.example.demo.services;

import com.example.demo.models.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car saveCar(Car car);

    Car editCar(Car car);

    Optional<Car> findById(Long id);

    void deleteCarById(Long id);

    Page<Car> findAll(Pageable pageable);

}
