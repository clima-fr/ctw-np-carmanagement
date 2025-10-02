package com.ctw.car.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "T_CAR")
public class CarEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    public UUID id;

    @Column(name = "BRAND", nullable = false)
    public String brand;

    @Column(name = "MODEL", nullable = false)
    public String model;

    @Column(name = "SEATS", nullable = true)
    public Integer seats;

    @Column(name = "LICENSE_PLATE", nullable = true)
    public String licensePlate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ENGINE_TYPE", nullable = false)
    public EngineType engineType;

    @Column(name = "AUTONOMY", nullable = true)
    public Integer autonomy;

    @Column(name = "COLOR", nullable = true)
    public String color;

    @Column(name = "IMAGE", columnDefinition = "TEXT", nullable = true)
    public String image;

    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    public LocalDateTime createdAt;

    @Column(name = "CREATED_BY", updatable = false)
    public String createdBy;

    public static Car toCar(CarEntity carEntity) {
        if (Objects.nonNull(carEntity)) {
            return new Car(carEntity.id, carEntity.brand, carEntity.model, carEntity.engineType, carEntity.seats, carEntity.licensePlate, carEntity.autonomy, carEntity.color, carEntity.image);
        }
        return null;
    }

    public static CarEntity fromCar(Car car) {
        CarEntity entity = new CarEntity();
        entity.brand = car.getBrand();
        entity.model = car.getModel();
        entity.engineType = car.getEngineType();
        entity.seats = car.getSeats();
        entity.licensePlate = car.getLicensePlate();
        entity.autonomy = car.getAutonomy();
        entity.color = car.getColor();
        entity.image = car.getImage();
        entity.createdAt = LocalDateTime.now();
        entity.createdBy = "system_user";
        return entity;
    }

    public void updateFromCar(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.engineType = car.getEngineType();
        this.seats = car.getSeats();
        this.licensePlate = car.getLicensePlate();
        this.autonomy = car.getAutonomy();
        this.color = car.getColor();
        this.image = car.getImage();
    }
}
