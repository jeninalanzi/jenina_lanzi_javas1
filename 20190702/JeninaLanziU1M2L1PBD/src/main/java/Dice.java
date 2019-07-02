import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        // Initiate Random
        Random random = new Random();

        // Dice 1 and 2 will each roll random value between 1-6.
        // Then put the total together in a variable.
        int firstDie = random.nextInt(6);
        int secondDie = random.nextInt(6);
        int totalRoll = firstDie+secondDie;

        // Output to the screen:
        System.out.println("HERE COMES THE DICE!\n");
        System.out.println("Roll #1: " + firstDie);
        System.out.println("Roll #2: " + secondDie);
        System.out.format("The total is %d !", totalRoll);
    }
}
