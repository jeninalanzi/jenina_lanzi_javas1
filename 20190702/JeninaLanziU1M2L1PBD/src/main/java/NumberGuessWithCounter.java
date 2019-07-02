import java.util.Random;
import java.util.Scanner;

public class NumberGuessWithCounter {
    public static void main(String[] args) {
        //Initiate Random & Scanner
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        // Initiate number of tries variable.
        int numberOfTries = 0;

        // Computer will guess a number.
        int computerGuess = random.nextInt(10);

        // Prompt user to choose a number between 1-10.
        // Save user's guess into a variable.
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        System.out.print("Your guess: ");
        int userGuess = Integer.parseInt(scan.nextLine());

        // While the user is guessing incorrectly, keep prompting a guess.
        // Once they are correct, let them know they won.
        while (userGuess != computerGuess) {
            numberOfTries++;
            System.out.println("That is incorrect. Guess again.");
            System.out.print("Your guess: ");
            userGuess = Integer.parseInt(scan.nextLine());
        }
        System.out.println("That's right! You're a good guesser.");
        System.out.format("It only took you %d tries.", numberOfTries);

    }
}
