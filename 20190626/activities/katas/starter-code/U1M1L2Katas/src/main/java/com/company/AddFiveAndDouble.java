package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for a number and save it in a variable.
        System.out.print("Enter any number: ");
        int number = scan.nextInt();

        // Close Scanner
        scan.close();

        // Add five to the number inputted by user and double that number
        int addFiveAndDouble = (number+5)*2;

        // Print to console
        System.out.println("Output: " + addFiveAndDouble);
    }
}
