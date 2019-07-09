package com.company.abstractapproach;

public abstract class Shape {
    private String name;
    private String color;
    private int xCoordinate;
    private int yCoordinate;

    // Default constructor ONLY for abstract class

    // Define abstract methods
    public abstract double area();
    public abstract double perimeter();

    // Getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
