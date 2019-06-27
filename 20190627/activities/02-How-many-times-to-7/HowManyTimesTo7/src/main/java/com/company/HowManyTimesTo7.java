package com.company;

import java.util.Random;

public class HowManyTimesTo7 {
    public static void main(String[] args) {
        // Initiate Random method.
        Random roll = new Random();

        // Declaring 2 dice variables.
        int dieOne;
        int dieTwo;

        // Initiate rollCount to 0.
        // Initiate rolls of 7's to 0.
        int rollCount = 0;
        int howManyTimesTo7 = 0;

        // Declaring sum of the 2-dice rolls.
        int sum;

        // For-loop to execute 100 times.
        for (int a = 0; a < 100; a++) {
            dieOne = roll.nextInt(6) + 1;
            dieTwo = roll.nextInt(6) + 1;
            sum = dieOne + dieTwo;

            if (sum != 7) {
                rollCount++;
            } else {
                howManyTimesTo7++;
            }

        }

        // Print final results to the console.
        System.out.println("=======================================================");
        System.out.println(" ");
        System.out.println("It took " + rollCount + " rolls before we got a 7!");
        System.out.println("We rolled a 7 " + howManyTimesTo7 + " times!");
    }

}
