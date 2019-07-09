package com.company.concreteapproach;

public class Square extends Shape {

    private double side;

    // Getters/setters
    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    // Implement methods inherited

    public void area() {
        double area = side * side;
        System.out.println(area);
    }

    public void perimeter() {
        double perimeter = side * 4;
        System.out.println(perimeter);
    }
}
