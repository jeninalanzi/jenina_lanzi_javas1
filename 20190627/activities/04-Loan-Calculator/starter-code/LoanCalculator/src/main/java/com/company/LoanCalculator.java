package com.company;

import java.util.Scanner;


public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for their mortgage amount, then save in a float variable.
        System.out.println("Type the amount of your mortgage: ");
        float mortgageLoan = scan.nextFloat();

        // Prompt user for the mortgage term in months and save result in integer variable.
        System.out.println("What is the term of the mortgage (in months)? ");
        int term = scan.nextInt();

        // Prompt user for the annual interest rate of the mortgage (just type the number of percentage):
        System.out.println("What is the annual interest of the mortgage? (numbers only): ");
        double interestInt = scan.nextDouble();
        double annualInterestRate = interestInt/100;

        // Convert annualInterestRate to monthlyInterestRate:
        double monthlyInterestRate = annualInterestRate/12;

        // Solve for parens first.
        double parens = Math.pow((1+monthlyInterestRate), term);
        System.out.printf("paren1 is %f %n", parens);


        // Solve for P (fixed monthly payment)
        double fixedMonthlyPayment = mortgageLoan * (monthlyInterestRate*parens) / (parens -1);

        // Display monthly payment to the user
        System.out.printf("Your monthly payment is $ %.2f", fixedMonthlyPayment);

        // Display loan total to the user


        // Calculate monthly mortgage payment
//        double result = Math.pow(4, 2);
//        System.out.printf("The result is %.2f", result);


        // Test
//        System.out.printf("You typed $ %.2f %n", mortgagePayment);
//        System.out.format("Your mortgage term is %d months %n", term);
//        System.out.printf("Your annual interest rate is %.2f !", annualInterestRate);
//        System.out.printf("The monthly interest rate is %.4f %n", monthlyInterestRate);
    }
}
