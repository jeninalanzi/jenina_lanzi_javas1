package com.company.model;

public class Car {
    private String make;
    private String model;
    private String color;
    private int year;
    private int odometerValue;

    // Constructor(s)
    public Car(String make, String model, String color, int year, int odometerValue) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.odometerValue = odometerValue;
    }

    public Car() {}

    // Getters/Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometerValue() {
        return odometerValue;
    }

    public void setOdometerValue(int odometerValue) {
        this.odometerValue = odometerValue;
    }

    // toString
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", odometerValue=" + odometerValue +
                '}';
    }
}
