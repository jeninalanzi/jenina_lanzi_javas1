package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user to select a number & save the input by using nextInt()
        System.out.print("Enter first number: ");
        int num1 = scan.nextInt();

        // Prompt user to select a number & save the input by using nextInt()
        System.out.print("Enter second number: ");
        int num2 = scan.nextInt();

        // Prompt user to select a number & save the input by using nextInt()
        System.out.print("Enter third number: ");
        int num3 = scan.nextInt();

        // Close Scanner
        scan.close();

        // Save product of 3 numbers in a variable and print to console.
        int product = num1*num2*num3;

        System.out.println("Output: " + product);
    }
}