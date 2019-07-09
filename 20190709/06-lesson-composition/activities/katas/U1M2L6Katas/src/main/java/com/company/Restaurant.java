package com.company;

public class Restaurant {
    // Properties (store type) and unique ones.
    private Store properties;
    private String cuisineType;
    private int numSeats;
    private int numEmployees;


    // G/S
    public Store getProperties() {
        return properties;
    }

    public void setProperties(Store properties) {
        this.properties = properties;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    // Methods unique to restaurant.
    public void seatGuest(int numGuests) {
        this.numSeats =- numGuests;
    }

    public void provideCheck() {}

    public void provideMenu() {}
}
