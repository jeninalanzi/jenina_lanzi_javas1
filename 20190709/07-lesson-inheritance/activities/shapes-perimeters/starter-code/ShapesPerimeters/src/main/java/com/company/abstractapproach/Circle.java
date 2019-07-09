package com.company.abstractapproach;

public class Circle extends Shape {

    private double radius;

    // Getter and setter
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    // Inherited methods
    public double area() {
        return radius * radius * Math.PI;
    }

    public double perimeter() {
        return radius * 2 * Math.PI;
    }
}
