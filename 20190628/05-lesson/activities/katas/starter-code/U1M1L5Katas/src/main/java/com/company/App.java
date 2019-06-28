package com.company;

public class App {
    // subtractTwo
    public static int subtract(int a, int b) {
        int value = a - b;
        return value;
    }
    // subtractOrZero
    public static int subtractOrZero(int a, int b) {
        int value = a - b;
        if (value < 0) {
            return 0;
        } else {
            return value;
        }
    }
    // Max
    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }
    // Min
    public static int min(int a, int b, int c) {
        if (a < c && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }
    // isLarger
    public static boolean isLarger(int first, int second) {
        if (first > second) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Call subtract and print.
        int resultOne = subtract(8, 2);
        System.out.println(resultOne);

        // Call subtractOrZero and print.
        int resultTwo = subtractOrZero(8, 10);
        System.out.println(resultTwo);

        // Call max and print.
        int resultThree = max(476, 8908, 89);
        System.out.println(resultThree);

        // Call min and print.
        int resultFour = min(650, 555, 77);
        System.out.println(resultFour);

        // Call isLarger and print.
        boolean resultFive = isLarger(9, 31);
        System.out.println(resultFive);
    }
}