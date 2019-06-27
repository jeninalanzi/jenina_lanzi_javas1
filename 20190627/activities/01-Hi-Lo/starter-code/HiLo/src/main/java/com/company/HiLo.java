package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {

        // Initiate Scanner
        Scanner scan = new Scanner(System.in);

        // Set user guess count to 0.
        int userGuessCount = 0;

        // 1. Display the message.
        System.out.println("Welcome to Hi-Low!");
        System.out.println("------------------------------------");
        System.out.println(" ");

        // 2. Prompt the user for their name.
        System.out.print("What is your name? ");
        String userName = scan.nextLine();

        // 3. Display message to the user.
        System.out.println("OK, " + userName + ", here are the rules:");
        System.out.println("[ Guess a number between 1-10. The computer will do the same. \n" +
                "If you guess the same number as the computer does, you win! \n" +
                "Otherwise, you can keep trying until you do guess the number. ]");
        System.out.println(" ");

        // 4. Computer will come up with a number between 1-100 (inclusive).
        int computerGuessNumber;

        // 4a. Initiate Random method which randomizes a value, then stores that guess:
        Random randomGenerator = new Random();
        computerGuessNumber = randomGenerator.nextInt(10 ) + 1;

        // 4b. Prompt user to guess a number.
        // Store the user's guess in an integer variable.
        int userGuessNumber;

        do {
            System.out.print("Guess a number between 1-10");
            userGuessNumber = scan.nextInt();
            userGuessCount++;

            if (userGuessNumber < computerGuessNumber) {
                System.out.println("Too low!");
            } else if (userGuessNumber > computerGuessNumber) {
                System.out.println(("Too high!"));
            }
        } while (userGuessNumber < computerGuessNumber || userGuessNumber > computerGuessNumber);

        System.out.println("Congratulations, " + userName + "! You win!");
        System.out.format("It took you %d guesses to find my number!", userGuessCount);

    }
}
