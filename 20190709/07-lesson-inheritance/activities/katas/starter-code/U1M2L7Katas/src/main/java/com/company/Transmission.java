package com.company;

public class Transmission {

    // POJO
    private String type;
    private double weight;
    private String dimensions;
    private int horsepower;
    private String safetyRating;

    // Default constructor

    // Getters/setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getSafetyRating() {
        return safetyRating;
    }

    public void setSafetyRating(String safetyRating) {
        this.safetyRating = safetyRating;
    }
}
