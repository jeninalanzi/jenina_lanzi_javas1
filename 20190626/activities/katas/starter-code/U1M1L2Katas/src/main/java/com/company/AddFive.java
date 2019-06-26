package com.company;

import java.util.Scanner;

public class AddFive {

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

        // Prompt user to select a number & save the input by using nextInt()
        System.out.print("Enter fourth number: ");
        int num4 = scan.nextInt();

        // Prompt user to select a number & save the input by using nextInt()
        System.out.print("Enter fifth number: ");
        int num5 = scan.nextInt();

        // Close Scanner
        scan.close();

        // Add all 5 numbers into a sum variable
        int sum = num1+num2+num3+num4+num5;

        // Print output to console
        System.out.println("Output: " + sum);

    }
}
