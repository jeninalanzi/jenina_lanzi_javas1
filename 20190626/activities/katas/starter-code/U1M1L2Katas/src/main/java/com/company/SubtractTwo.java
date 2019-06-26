package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user to select a number & save the input by using nextInt()
        System.out.print("Enter first number: ");
        int num1 = scan.nextInt();

        // Prompt user to select a number & save the input by using nextInt()
        System.out.print("Enter second number: ");
        int num2 = scan.nextInt();

        // Close Scanner
        scan.close();

        // Subtract num2 from num1 and save result.
        int difference = num1-num2;

        System.out.println("Output: " + difference);

    }
}
