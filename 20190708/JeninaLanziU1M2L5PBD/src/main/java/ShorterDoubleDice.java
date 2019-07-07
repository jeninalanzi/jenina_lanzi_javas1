import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {
        // Initiate Random
        Random roll = new Random();

        System.out.println("HERE COMES THE DICE! \n");

        int die1;
        int die2;

        do {
            // Declare dice and their random rolls.
            die1 = roll.nextInt(6) + 1;
            die2 = roll.nextInt(6) + 1;

            // Declare sum of the dice rolls.
            int sum = die1+die2;

            // Print roll result and total to the console.
            System.out.println("Roll #1: " + die1);
            System.out.println("Roll #2: " + die2);
            System.out.format("The total is %d! %n", sum);
            System.out.println(" ");
        } while (die1 != die2);

    }
}
