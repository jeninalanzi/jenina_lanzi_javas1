package com.company.concreteapproach;

public class Circle extends Shape {
    private double radius;

    // Getter/Setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Implement inherited methods
    public void area() {
        double area = radius * radius * Math.PI;
        System.out.println(area);
    }

    public void perimeter() {
        double perimeter = 2 * Math.PI * radius;
        System.out.println(perimeter);
    }


}
