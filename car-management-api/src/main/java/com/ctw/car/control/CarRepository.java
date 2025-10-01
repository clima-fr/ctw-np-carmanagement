package com.ctw.car.control;

import com.ctw.car.entity.Car;
import com.ctw.car.entity.CarEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Dependent
public class CarRepository implements PanacheRepository<CarEntity> {
    public List<Car> fetchAllCars() {
        return listAll()
                .stream()
                .map(CarEntity::toCar)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public Car fetchCarById(String id) {
        CarEntity entity = CarEntity.findById(UUID.fromString(id));
        if (entity == null) {
            return null;
        }
        return CarEntity.toCar(entity);
    }
    @Transactional
    public Car saveCar(Car car) {
        CarEntity entity = CarEntity.fromCar(car);
        persist(entity);
        return CarEntity.toCar(entity);
    }

}
