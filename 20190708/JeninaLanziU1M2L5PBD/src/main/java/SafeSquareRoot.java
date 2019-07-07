import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {

        // Scanner initiate and prompt
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int userChoice = Integer.parseInt(scan.nextLine());

        while (userChoice < 0) {
            System.out.println("You cant' take the square root of a negative number, silly.");
            System.out.print("Try again: ");
            userChoice = Integer.parseInt(scan.nextLine());
        }
        System.out.format("The square root of %d is " + Math.sqrt(userChoice), userChoice);
    }
}
