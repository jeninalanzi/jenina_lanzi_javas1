package com.company;

import com.company.interfaces.Vehicle;

public class Car implements Vehicle {

    // POJO
    private String make;
    private String model;
    private int milesTraveled;

    // Constructor - default

    // Getters/Setters
    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    // -------------------------------------------------------------------------
    // Methods needed per Vehicle interface.

    // Make this method add the integer of miles driven to milesTraveled.
    public void drive(int miles) {
        this.milesTraveled += miles;
    }

    // Make this method display the miles traveled so far.
    public void displayMilesTraveled() {
        System.out.println("Miles traveled: " + this.milesTraveled);
    }
}
