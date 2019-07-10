package pbd;

import java.util.Scanner;

public class BabyNim {

    public static void main(String[] args) {
        // Initiate Scanner
        Scanner scan = new Scanner(System.in);

        // Create piles of 3 counters each.
        int pileA = 3;
        int pileB = 3;
        int pileC = 3;
        int total = 9;

        // Display the piles and their amount:
        System.out.format("A: %d     B: %d     C: %d %n", pileA, pileB, pileC);

        // Prompt user to select a pile:
        System.out.print("Choose a pile: ");
        String userChoice = scan.nextLine();

        System.out.println("Choose how many to remove from pile " + userChoice + ": ");
        int amountRemoved = Integer.parseInt(scan.nextLine());

        if (userChoice.equals("A")) {
            pileA -= amountRemoved;
            total -= amountRemoved;
        } else if (userChoice.equals("B")) {
            pileB -= amountRemoved;
            total -= amountRemoved;
        } else if (userChoice.equals("C")) {
            pileC -= amountRemoved;
            total -= amountRemoved;
        }

        // Keep looping while the piles are empty.
        while (total != 0) {
            // Display the remainder of each pile to user:
            System.out.format("A: %d     B: %d     C: %d %n", pileA, pileB, pileC);

            // Prompt user to select another pile:
            System.out.print("Choose a pile: ");
            userChoice = scan.nextLine();

            System.out.println("Choose how many to remove from pile " + userChoice + ": ");
            amountRemoved = Integer.parseInt(scan.nextLine());

            if (userChoice.equals("A")) {
                pileA -= amountRemoved;
                total -= amountRemoved;
            } else if (userChoice.equals("B")) {
                pileB -= amountRemoved;
                total -= amountRemoved;
            } else if (userChoice.equals("C")) {
                pileC -= amountRemoved;
                total -= amountRemoved;
            }
        }

        System.out.println("All piles are empty. Good job!");
    }

}
