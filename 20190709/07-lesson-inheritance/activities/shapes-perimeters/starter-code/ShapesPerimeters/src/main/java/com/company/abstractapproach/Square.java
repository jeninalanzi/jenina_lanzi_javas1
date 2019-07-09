package com.company.abstractapproach;

public class Square extends Shape {

    private double side;


    // Getter & setter
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }


    // Inherited methods
    public double area() {
        return side * side;
    }

    public double perimeter() {
        return side * 4;
    }
}
