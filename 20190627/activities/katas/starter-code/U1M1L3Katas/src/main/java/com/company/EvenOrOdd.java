package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select a number: ");
        int userChoice = scan.nextInt();

        if (userChoice % 2 == 0) {
            System.out.println("The number you chose is even!");
        } else {
            System.out.println("The number you chose is odd!");
        }

    }
}
