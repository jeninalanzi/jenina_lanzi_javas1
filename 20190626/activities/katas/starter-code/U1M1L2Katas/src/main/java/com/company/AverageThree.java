package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        // Object that helps us capture user input
        Scanner scan = new Scanner(System.in);

        // Ask the user for number one
        System.out.println("Pick a number for #1: ");
        // Save's user's answers in a variable.
        float numberOne = Float.parseFloat(scan.nextLine());

        // Ask the user for number two
        System.out.println("Pick a number for #2: ");
        // Save's user's answers in a variable.
        float numberTwo = Float.parseFloat(scan.nextLine());

        // Ask the user for number three
        System.out.println("Pick a number for #3: ");
        // Save's user's answers in a variable.
        float numberThree = Float.parseFloat(scan.nextLine());

//        // Test
//        System.out.println("You chose " + numberOne + ", " + numberTwo + ", and " + numberThree);

        // Add all user's numbers into a sum variable
        float sum = numberOne + numberTwo + numberThree;

        // Test
        System.out.format("You average of your numbers is %f", sum/3);

    }
}
