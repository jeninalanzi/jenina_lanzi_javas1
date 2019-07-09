package com.company.abstractapproach;

public class AppTester {
    public static void main(String[] args) {
        Square square1 = new Square();
        square1.setSide(4);
        square1.setName("square");
        square1.setColor("green");
        System.out.println(square1);
    }
}
