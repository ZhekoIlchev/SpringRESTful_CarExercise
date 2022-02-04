package com.example.demo;

import com.example.demo.models.Car;
import com.example.demo.models.Engine;
import com.example.demo.models.Owner;
import com.example.demo.reposotories.CarRepository;
import com.example.demo.reposotories.EngineRepository;
import com.example.demo.reposotories.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
    }

//	@Bean
//	public CommandLineRunner demo (EngineRepository engineRepository, OwnerRepository ownerRepository,
//								   CarRepository carRepository) {
//		return args -> {
//
//			Engine engineFirst = new Engine("120OPDO23", 6.5, 560);
//			Engine engineSecond = new Engine("120HFDO89", 5.5, 450);
//			Engine engineThird = new Engine("120HFKL45", 4.5, 350);
//			engineRepository.save(engineFirst);
//			engineRepository.save(engineSecond);
//			engineRepository.save(engineThird);
//
//			Owner ownerFirst = new Owner("Ivan", "Ivanov", "Ivanov", LocalDate.of(2005, Month.APRIL, 15));
//			Owner ownerSecond = new Owner("Stoyan", "Stoyanov", "Stoyanov", LocalDate.of(2006, Month.MAY, 16));
//			Owner ownerThird = new Owner("Boyan", "Boyanov", "Boyanov", LocalDate.of(2007, Month.JUNE, 17));
//			ownerRepository.save(ownerFirst);
//			ownerRepository.save(ownerSecond);
//			ownerRepository.save(ownerThird);
//
//			Car carFirst = new Car(engineFirst, ownerFirst, "Mercedes", "S class", "2022", "PB1234CA");
//			Car carSecond = new Car(engineSecond, ownerSecond, "BMW", "7-Series", "2021", "PB5678CA");
//			Car carThird = new Car(engineThird, ownerThird, "Audi", "A8", "2020", "PB4567CA");
//			carRepository.save(carFirst);
//			carRepository.save(carSecond);
//			carRepository.save(carThird);
//
//		};
//	}
}
