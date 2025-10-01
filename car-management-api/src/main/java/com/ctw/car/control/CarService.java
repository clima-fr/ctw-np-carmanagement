package com.ctw.car.control;

import com.ctw.car.entity.Car;
import com.ctw.car.entity.EngineType;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.List;

@Dependent
public class CarService {
    private final CarRepository carRepository;

    @Inject
    public CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.fetchAllCars();
    }

    public Car getCarById(String id) {
        return carRepository.fetchCarById(id);
    }

    public Car createCar(Car car) {
        return carRepository.saveCar(car);
    }

}
