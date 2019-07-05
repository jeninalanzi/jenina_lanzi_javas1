package exercise2;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {

        // Initiate Scanner & prompt
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a number between 1-10: ");
        int userChoice = Integer.parseInt(scan.nextLine());

//        System.out.println(userChoice);

        while (userChoice < 1 || userChoice > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
            System.out.print("Please enter a number between 1-10: ");
            userChoice = Integer.parseInt(scan.nextLine());
        }
        System.out.println(userChoice);

    }
}
