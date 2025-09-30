package com.ctw.car.entity;

import java.util.UUID;

public class Car {

    private UUID id;
    private String model;
    private String brand;
    private EngineType engineType;
    private Integer seats;
    private String licensePlate;
    private Integer autonomy;
    private String color;
    private String image;

    public Car() {

    }

    public Car(UUID id, String brand, String model, EngineType engineType,
    Integer seats,  String licensePlate, Integer autonomy,
    String color, String image) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.seats = seats;
        this.licensePlate = licensePlate;
        this.autonomy = autonomy;
        this.color = color;
        this.image = image;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(Integer autonomy) {
        this.autonomy = autonomy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
