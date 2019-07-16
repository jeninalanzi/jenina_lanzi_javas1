package com.company;

import com.company.service.Inventory;

import java.util.Scanner;

public class AppTest2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean programRunning = true;

        // Begin prompt
        System.out.println("-----------------------------------------------------");
        System.out.println("                    Welcome To:                       ");
        System.out.println("               CarInventory Manager!                 ");
        System.out.println("-----------------------------------------------------");
        System.out.println("Please select from the following options:");
        System.out.println(" \n" +
                "[1] Add A Car \n" +
                "[2] Delete A Car \n" +
                "[3] List All Cars \n" +
                "[4] Search by... \n" +
                "[5] EXIT");

        // Capture user's choice
        int userInput = Integer.parseInt(scan.nextLine());

        // Switch statement to navigate the program by command:
        switch (userInput) {
            case 1:
                while (programRunning) {
                    inventory.add();
                }
                System.exit(0);
                break;
            case 2:
                System.out.println("You chose to delete!");
                break;
            case 3:
                System.out.println("You chose to list all!");
                break;
            case 4:
                System.out.println("You chose to search!");
                break;
            case 5:
                System.out.println("You chose to Exit!");
                System.exit(0);
                break;
            default:
                System.out.println("You have entered an invalid input, please try again.");

        }


    }
}
