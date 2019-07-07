import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {

    public static void main(String[] args) {
        // Initiate Random
        Random random = new Random();

        // Initiate some necessary variables.
        int ace = random.nextInt(3) + 1;

        // Scanner and prompt
        Scanner scan = new Scanner(System.in);
        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.");
        System.out.println(" ");
        System.out.println("Which one is the ace?");
        System.out.println(" ");
        System.out.println("     ##      ##     ##");
        System.out.println("     ##      ##     ##");
        System.out.println("     1       2      3 ");
        System.out.println(" ");
        System.out.print("> ");

        // Save user's choice into a variable.
        int userChoice = Integer.parseInt(scan.nextLine());

        // Conditionals based on user's choice.
        // Additional conditional, to ensure user picks a valid number.
        if (userChoice < 1 || userChoice > 3) {
            System.out.println("That was an invalid choice. Please choose from 1-3.");
        } else if (userChoice != ace) {
            System.out.format("Ha! Fast Eddie wins again! The ace was card number %d", ace);
        } else {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        }

    }

}
