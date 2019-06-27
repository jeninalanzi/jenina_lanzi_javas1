package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userChoice;

        do {
            System.out.println("Pick a number between 1 and 100: ");
            userChoice = scan.nextInt();
        } while (userChoice != 42);

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
