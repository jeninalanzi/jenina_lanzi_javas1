package exercise1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MonthConverterIf {
    public static void main(String[] args) {

        // Initiate Scanner and prompt user for a number.
        // Store the user's choice into a usable variable.
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a number between 1 and 12: ");
        int userChoice = Integer.parseInt(scan.nextLine());

        // If/else if conditional output:
        if (userChoice == 1) {
            System.out.println("January");
        } else if (userChoice == 2) {
            System.out.println("February");
        } else if (userChoice == 3) {
            System.out.println("March");
        } else if (userChoice == 4) {
            System.out.println("April");
        } else if (userChoice == 5) {
            System.out.println("May");
        } else if (userChoice == 6) {
            System.out.println("June");
        } else if (userChoice == 7) {
            System.out.println("July");
        } else if (userChoice == 8) {
            System.out.println("August");
        } else if (userChoice == 9) {
            System.out.println("September");
        } else if (userChoice == 10) {
            System.out.println("October");
        } else if (userChoice == 11) {
            System.out.println("November");
        } else if (userChoice == 12) {
            System.out.println("December");
        } else {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }

    }
}
