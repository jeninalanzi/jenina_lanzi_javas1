import java.sql.SQLOutput;
import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {

        // Initiate variables
        int a;
        int b;
        int c;
        int sum;

        // Scanner initiate & prompt
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter three integers:");
        System.out.print("Side 1: ");
        a = Integer.parseInt(scan.nextLine());
        System.out.print("Side 2: ");
        b = Integer.parseInt(scan.nextLine());

        // Ensure a is always smaller than b. Else, reprompt.
        while (a > b) {
            System.out.println(b + " is smaller than " + a + ". Try again.");
            System.out.print("Side 2: ");
            b = Integer.parseInt(scan.nextLine());
        }

        // Ask for c.
        System.out.print("Side 3:");
        c = Integer.parseInt(scan.nextLine());

        // Ensure b is always smaller than c. Else, reprompt.
        while (b > c) {
            System.out.println(c + " is smaller than " + b + ". Try again.");
            System.out.println("Side 3: ");
            c = Integer.parseInt(scan.nextLine());
        }

        // Print the user's choices to the console.
        System.out.format("Your three sides are: %d, %d, %d %n", a, b, c);

        // Calculate to see if the integers entered make a right triangle.
        // The calculation for a right triangle is a(2) + b(2) = c(2) (squared).
        if (a*a + b*b == c*c) {
            System.out.println("These sides *do* make a right triangle. Yippy-skippy!");
        } else {
            System.out.println("NO! These sides do not make a right triangle!");
        }

    }
}
