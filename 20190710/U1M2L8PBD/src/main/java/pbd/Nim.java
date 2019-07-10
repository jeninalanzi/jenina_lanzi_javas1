package pbd;

import java.util.Random;
import java.util.Scanner;

public class Nim {

    public static void displayPiles(int a, int b, int c) {
        System.out.println("A: " + a + "     B: " + b + "     C: " + c);
    }

    public static String choosePile(String player) {
        // Prompt user to pick which pile.
        Scanner scan = new Scanner(System.in);
        System.out.print(player + ", choose a pile: ");
        String pileChosen = scan.nextLine();

        return pileChosen;
    }



    public static void main(String[] args) {

        // Initiate Random and Scan.
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // The piles - I'm generating random but 3-10
        int pileA = random.nextInt(10) + 3;
        int pileB = random.nextInt(10) + 3;
        int pileC = random.nextInt(10) + 3;

        // A boolean to see who's turn it is.
        boolean isPlayerOne;

        // BEGIN GAME
        // 1. Prompt the players for their names.
        System.out.println("Player 1, enter your name: ");
        String player1 = scan.nextLine();
        System.out.println("Player 2, enter your name: ");
        String player2 = scan.nextLine();

        // 2. Display the piles
        displayPiles(pileA, pileB, pileC);

        // 3. Player one starts
        choosePile(player1);
            


    }
}
