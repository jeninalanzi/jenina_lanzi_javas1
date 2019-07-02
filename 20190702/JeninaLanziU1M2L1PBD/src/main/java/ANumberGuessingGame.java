import java.util.Random;
import java.util.Scanner;

public class ANumberGuessingGame {
    public static void main(String[] args) {

        // Store the computer's guess with a Random.
        Random random = new Random();
        int computerPick = random.nextInt(10);

        // Initiate Scanner and prompt user to guess a number.
        Scanner scan = new Scanner(System.in);
        System.out.println("I'm thinking of a number from 1 to 10");
        System.out.print("Your guess: ");
        int userGuess = Integer.parseInt(scan.nextLine());

        // Check conditions
        if (userGuess == computerPick) {
            System.out.format("That's right! My secret number was %d !", computerPick);
        } else {
            System.out.format("Sorry, but I was really thinking of %d .", computerPick);
        }
    }
}
