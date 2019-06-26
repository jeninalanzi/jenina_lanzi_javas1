package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user to select a number & save the input by using nextInt()
        System.out.print("Enter any number: ");
        int number = scan.nextInt();

        // Close Scanner
        scan.close();

        // Save product of 3 numbers in a variable and print to console.
        int resultPlus13 = number+13;

        System.out.println("Output: " + resultPlus13);

    }
}
