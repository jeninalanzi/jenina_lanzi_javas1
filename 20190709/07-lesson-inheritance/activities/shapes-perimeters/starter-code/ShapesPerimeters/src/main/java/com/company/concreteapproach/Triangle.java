package com.company.concreteapproach;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    // Getters/setters
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    // Implement methods inherited

    @Override
    public void area() {
        double p = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(p * (p - side1) * (p - side2) * (p-side3));
        System.out.println(area);
    }

    public void perimeter() {
        double perimeter = side1 + side2 + side3;
        System.out.println(perimeter);
    }
}
