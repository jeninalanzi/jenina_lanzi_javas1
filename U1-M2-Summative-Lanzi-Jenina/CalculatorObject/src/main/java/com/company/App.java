package com.company;

public class App {

    public static void main(String[] args) {

        Calculator userMath = new Calculator();

        System.out.println("1 + 1 = " + userMath.add(1,1));
        System.out.println("23 - 52 = " + userMath.subtract(23, 52));
        System.out.println("34 * 2 = " + userMath.multiply(34, 2));
        System.out.println("12 / 3 = " + userMath.divide(12, 3));
        System.out.println("12 / 7 = " + userMath.divide(12, 7));
        System.out.println("3.4 + 2.3 = " + userMath.add(3.4, 2.3));
        System.out.println("6.7 * 4.4 = " + userMath.multiply(6.7, 4.4));
        System.out.println("5.5 - 0.5 = " + userMath.subtract(5.5, 0.5));
        System.out.println("10.8 / 2.2 = " + userMath.divide(10.8, 2.2));

    }

}
