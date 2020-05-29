package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category= new Category();
        Set<Car>cars= new HashSet<>();
        category.setType("Compact");
        category.setCars(cars);
        categoryRepository.save(category);

        Category category1= new Category();
        category1.setType("Pick UP");
        categoryRepository.save(category1);
        Car car= new Car();
        car.setManufacturer("Toyota");
        car.setModel("Camry");
        car.setMileage(5000);
        car.setYear(2016);
        car.setCategory(category);
        cars.add(car);


    }
}
