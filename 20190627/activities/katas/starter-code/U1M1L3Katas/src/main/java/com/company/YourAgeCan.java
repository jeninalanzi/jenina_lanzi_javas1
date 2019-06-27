package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How old are you? (Write in digits only): ");

        int userAge = scan.nextInt();

        // Check for voting age
        if (userAge >= 18) {
            System.out.println("You can vote!");
        }

        // Check for alcohol drinking age
        if (userAge >= 21) {
            System.out.println("You can legally drink alcohol!");
        }

        // Check to see if user can be President
        if (userAge >= 35) {
            System.out.println("You can be the US President.");
        }

        // Check if eligible for AARP
        if (userAge >= 55) {
            System.out.println("You are eligible for AARP!");
        }

        // Check if user can retire
        if (userAge >= 65) {
            System.out.println("Congratulations, you can retire too!");
        }

        // Check if user is considered an octogenarian (80-89)
        if (userAge >=80 && userAge <= 89) {
            System.out.println("You are an octogenarian!");
        }

        // Check if user is OVER 100 years old
        if (userAge > 100) {
            System.out.println("You are over a century old! You're officially a legend.");
        }
    }
}