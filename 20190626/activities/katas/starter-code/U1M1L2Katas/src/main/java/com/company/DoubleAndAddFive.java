package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt the user to select any number and save to variable.
        System.out.print("Enter any number: ");
        int number = scan.nextInt();

        // Close Scanner
        scan.close();

        // Double the number inputted by the user, then add 5.
        int doubleAndAddFive = number*2 + 5;

        // Print output to console.
        System.out.println("Output: " + doubleAndAddFive);
    }
}
