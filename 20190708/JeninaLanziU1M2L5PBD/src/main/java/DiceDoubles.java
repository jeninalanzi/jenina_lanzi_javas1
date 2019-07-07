import java.util.Random;

public class DiceDoubles {
    public static void main(String[] args) {

        // Initiate Random
        Random roll = new Random();

        // Declare dice and their random rolls.
        int die1 = roll.nextInt(6) + 1;
        int die2 = roll.nextInt(6) + 1;

        // Declare sum of the dice rolls.
        int sum = die1+die2;

        // Print roll result and total to the console.
        System.out.println("Roll #1: " + die1);
        System.out.println("Roll #2: " + die2);
        System.out.format("The total is %d! %n", sum);
        System.out.println(" ");

        // Continue to loop until the dice rolls doubles.
        while (die1 != die2) {
            die1 = roll.nextInt(6) + 1;
            die2 = roll.nextInt(6) + 1;
            sum = die1+die2;

            System.out.println("Roll #1: " + die1);
            System.out.println("Roll #2: " + die2);
            System.out.format("The total is %d! %n", sum);
            System.out.println(" ");
        }

    }
}
