package pbd;

import java.util.Random;
import java.util.Scanner;

public class Nim {

    public static void displayPiles(int a, int b, int c) {
        System.out.println("A: " + a + "     B: " + b + "     C: " + c);
    }


    public static void main(String[] args) {

        // Initiate Random and Scan.
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // The piles - I'm generating random but 3-10
        int pileA = random.nextInt(10) + 3;
        int pileB = random.nextInt(10) + 3;
        int pileC = random.nextInt(10) + 3;
        int total = pileA + pileB + pileC;

        // A boolean to see who's turn it is.
        boolean isPlayerOne = true;

        // BEGIN GAME
        // 1. Prompt the players for their names.
        System.out.println("Player 1, enter your name: ");
        String player1 = scan.nextLine();
        System.out.println("Player 2, enter your name: ");
        String player2 = scan.nextLine();


        do {
            // Display the piles
            displayPiles(pileA, pileB, pileC);

            // 3. Player one starts
            System.out.println(player1 + ", choose from the pile: ");
            String playerOneChoice = scan.nextLine();

            System.out.println("How many to remove from pile " + playerOneChoice + "? ");
            int numberToRemove = Integer.parseInt(scan.nextLine());

            // When player1 makes a number choice, hand turn over to player2
            if (playerOneChoice.equals("A")) {
                pileA -= numberToRemove;
                total -= numberToRemove;
                isPlayerOne = false;
            } else if (playerOneChoice.equals("B")) {
                pileB -= numberToRemove;
                total -= numberToRemove;
                isPlayerOne = false;
            } else if (playerOneChoice.equals("C")) {
                pileC -= numberToRemove;
                total -=numberToRemove;
                isPlayerOne = false;
            }

            // Display the piles
            displayPiles(pileA, pileB, pileC);

            // 3. Player two starts
            System.out.println(player2 + ", choose from the pile: ");
            String playerTwoChoice = scan.nextLine();

            System.out.println("How many to remove from pile " + playerTwoChoice + "? ");
            numberToRemove = Integer.parseInt(scan.nextLine());

            // When player2 makes a number choice, hand turn over to player1
            if (playerTwoChoice.equals("A")) {
                pileA -= numberToRemove;
                total -= numberToRemove;
                isPlayerOne = true;
            } else if (playerTwoChoice.equals("B")) {
                pileB -= numberToRemove;
                total -= numberToRemove;
                isPlayerOne = true;
            } else if (playerTwoChoice.equals("C")) {
                pileC -= numberToRemove;
                total -=numberToRemove;
                isPlayerOne = true;
            }
        } while (total > 0);

        if (total == 0 && !isPlayerOne) {
            System.out.println(player2 + " is the winner!");
        } else if (total == 0 && isPlayerOne) {
            System.out.println(player1 + " is the winner!");
        }


    }
}
