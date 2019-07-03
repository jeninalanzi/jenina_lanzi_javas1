package com.company;

public class Car {

    // Properties
    private String make;
    private String model;
    private String type;
    private String color;
    private String engine;
    private String transmission;
    private int numDoors;
    private double mpg;
    private int milesDriven;

    // Car constructor
    public Car(String make, String model, String type, String color, String engine, String transmission, int numDoors, double mpg, int milesDriven) {
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.numDoors = numDoors;
        this.mpg = mpg;
        this.milesDriven = milesDriven;
    }

    // Methods from UML
    public void drive(int miles) {
        this.milesDriven += miles;
    }

    public void honk() {
        System.out.println("Honk! Honk!");
    }

    // Getters and setters

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getNumDoors() {
        return this.numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public double getMpg() {
        return this.mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public int getMilesDriven() {
        return this.milesDriven;
    }

    public void setMilesDriven(int milesDriven) {
        this.milesDriven = milesDriven;
    }
}
