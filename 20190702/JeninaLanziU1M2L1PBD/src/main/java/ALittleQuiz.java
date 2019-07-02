import java.util.Scanner;

public class ALittleQuiz {

    public static void main(String[] args) {

        // Initiate some global variables.
        int score = 0;

        // Initiate Scanner
        Scanner scan = new Scanner(System.in);

        // Question 1
        System.out.println("What is the capital of Hawaii?");
        System.out.println("     1. Chicago");
        System.out.println("     2. Honolulu");
        System.out.println("     3. Boston");
        System.out.print("> ");

        int answer = Integer.parseInt(scan.nextLine());
        if (answer != 2) {
            System.out.println("Sorry, that is the wrong answer.. \n");
        } else {
            score++;
            System.out.println("Correct! \n");
        }

        // Question 2
        System.out.println("Which cheese is traditionally used for pizzas?");
        System.out.println("     1. Asiago");
        System.out.println("     2. Pepperjack");
        System.out.println("     3. Mozzarella");
        System.out.print("> ");

        int answer2 = Integer.parseInt(scan.nextLine());
        if (answer2 != 3) {
            System.out.println("Sorry, that is the wrong cheese! \n");
        } else {
            score++;
            System.out.println("You're right! \n");
        }

        // Question 3
        System.out.println("If you mix the colors red and white, do you get pink?");
        System.out.println("     1. Yes");
        System.out.println("     2. No");
        System.out.print("> ");

        int answer3 = Integer.parseInt(scan.nextLine());
        if (answer3 != 1) {
            System.out.println("Wrong, it DOES create the color pink! \n");
        } else {
            score++;
            System.out.println("You did it again! \n");
        }

        // Final message and score output
        System.out.println(" ");
        System.out.format("Overall, you got %d out of 3 correct. %n", score);
        System.out.println("Thanks for playing!");
    }
}
