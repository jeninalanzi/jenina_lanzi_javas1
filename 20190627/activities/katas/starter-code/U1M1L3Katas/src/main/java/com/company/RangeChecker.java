package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int userAnswer;

        do {
            System.out.println("Pick a number between 15 and 32: ");
            userAnswer = scan.nextInt();
        } while (userAnswer < 15 || userAnswer > 32);

        System.out.println(userAnswer);
    }
}
