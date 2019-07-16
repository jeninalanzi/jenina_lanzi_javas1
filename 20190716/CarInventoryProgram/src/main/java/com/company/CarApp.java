package com.company;

import com.company.service.Inventory;

import java.util.Scanner;

public class CarApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // WELCOME SCREEN
        System.out.println("-----------------------------------------------------");
        System.out.println("                    Welcome To:                       ");
        System.out.println("               CarInventory Manager!                 ");
        System.out.println("-----------------------------------------------------");

        // Instantiate new Inventory object
        Inventory inventory = new Inventory();

        // Attain user's choice through prompts
        int userSelection = promptUser();

        // Conditional
        boolean isRunning = true;
        while (isRunning) {
            switch (userSelection) {
                case 1:
                    System.out.println(" ");
                    inventory.add();
                    userSelection = promptUser();
                    break;
                case 2:
                    System.out.println(" ");
                    inventory.delete();
                    userSelection = promptUser();
                    break;
                case 3:
                    System.out.println(" ");
                    inventory.listAll();
                    userSelection = promptUser();
                    break;
                case 4:
                    System.out.println("You picked 4");
                    break;
                case 5:
                    System.out.println("You picked 5");
                    isRunning = false;
                    break;
                default:
                    System.out.println("That input isn't valid!\n");
                    break;
            }
        }

        if (!isRunning) {
            System.out.println("Thank you for using. Goodbye!");
            System.exit(0);
        }


    }

    // Prompt method
    public static int promptUser() {
        // Scanner
        Scanner scan = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * ");
        System.out.println("Please select from the following options:");
        System.out.println(" \n" +
                "[1] Add A Car \n" +
                "[2] Delete A Car \n" +
                "[3] List All Cars \n" +
                "[4] Search by... \n" +
                "[5] EXIT \n");
        System.out.print(" YOUR CHOICE: >> ");

        // Store input & return
        int userInput = Integer.parseInt(scan.nextLine());
        return userInput;
    }



    //        boolean isRunning = true;
//        int userInput = 0;
//
//        try {
//            // Displays options for user and returns their input.
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Please select from the following options:");
//            System.out.println(" \n" +
//                    "[1] Add A Car \n" +
//                    "[2] Delete A Car \n" +
//                    "[3] List All Cars \n" +
//                    "[4] Search by... \n" +
//                    "[5] EXIT");
//
//            // Capture user's choice & return
//            userInput = Integer.parseInt(scan.nextLine());
//        } catch(NumberFormatException e) {
//            System.out.println("That is NOT a valid number!");
//        }

}
