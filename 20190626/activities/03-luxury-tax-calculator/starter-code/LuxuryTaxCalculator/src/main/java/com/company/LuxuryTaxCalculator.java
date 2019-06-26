package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user to enter salary for playerOne:
        System.out.print("Please enter player one's salary: ");
        int playerOne = scan.nextInt();

        // Prompt user to enter salary for playerTwo:
        System.out.print("Please enter player two's salary: ");
        int playerTwo = scan.nextInt();

        // Prompt user to enter salary for playerThree:
        System.out.print("Please enter player three's salary: ");
        int playerThree = scan.nextInt();

        scan.close();

        int sum = playerOne+playerTwo+playerThree;
        System.out.format("The total salaries is $ %d.%n", sum);

        int spendingLimit = 40000000;

        // Test
//        System.out.print(sum);

        if (sum > spendingLimit) {
            float excess = (sum-spendingLimit)*0.18f;
            System.out.format("The luxury tax is %f", excess);
        }

    }
}
