package com.example.demo.controllers;

import com.example.demo.dtos.CarDto;
import com.example.demo.dtos.EngineDto;
import com.example.demo.exceptions.EngineNotFoundException;
import com.example.demo.models.Car;
import com.example.demo.models.Engine;
import com.example.demo.reposotories.CarRepository;
import com.example.demo.services.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto newCar) {
        Car car = modelMapper.map(newCar, Car.class);
        Car createdCar = carService.saveCar(car);
        CarDto mappedDto = modelMapper.map(createdCar, CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<CarDto> editCarById(@Valid @RequestBody CarDto CarDto, @PathVariable(value = "id") Long id) {
        Optional<Car> optionalCar = carService.findById(id);
        if (optionalCar.isEmpty()) {
            throw new EngineNotFoundException(id);
        }

        Car car = modelMapper.map(CarDto, Car.class);
        car.setId(id);
        Car editedCar = carService.saveCar(car);
        CarDto mappedCar = modelMapper.map(editedCar, CarDto.class);
        return ResponseEntity.ok(mappedCar);


    }

    @GetMapping("/{id}")
    ResponseEntity<CarDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Car> optionalCar = carService.findById(id);
        if (optionalCar.isEmpty()) {
            throw new EngineNotFoundException(id);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<CarDto> deleteCarById(@PathVariable(value = "id") Long id) {
        Optional<Car> optionalCar = carService.findById(id);
        if (optionalCar.isEmpty()) {
            throw new EngineNotFoundException(id);
        }
        carService.deleteCarById(id);
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Car> getCar(Pageable pageable) {
        return carService.findAll(pageable);
    }
}
