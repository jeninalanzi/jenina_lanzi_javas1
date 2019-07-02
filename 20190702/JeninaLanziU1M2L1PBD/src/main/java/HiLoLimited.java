import org.omg.CORBA.INTERNAL;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class HiLoLimited {
    public static void main(String[] args) {
        // initiate Random & Scanner
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        // Declare some initial variables
        int guessesLeft = 6;
        int randomPick = random.nextInt(100);
        int numberOfGuessed = 1;

        // Prompt user to begin guessing.
        System.out.println("I'm thinking of a number between 1-100. You have 7 guesses.");
        System.out.print("First guess: ");
        int userGuess = Integer.parseInt(scan.nextLine());

        // While guess is wrong and there are still guesses left,
        // decrement from the guessesLeft and let user know.
        while (userGuess != randomPick && guessesLeft > 0) {
            // Decrement guessesLeft & increment numberOfGuessed
            guessesLeft--;
            numberOfGuessed++;

            if (userGuess < randomPick && guessesLeft > 0) {
                System.out.println("Too low!");
            } else if (userGuess > randomPick && guessesLeft > 0){
                System.out.println("Too high!");
            }

            // Reprompt
            System.out.format("Guess # %d : ", numberOfGuessed);
            userGuess = Integer.parseInt(scan.nextLine());
        }

        if (userGuess != randomPick && guessesLeft == 0) {
            System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
        } else {
            System.out.println("You guessed it! What are the odds?!");
        }

    }
}
