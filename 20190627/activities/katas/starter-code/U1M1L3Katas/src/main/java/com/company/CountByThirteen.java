package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any number: ");
        int userNumber = Integer.parseInt(scan.nextLine());

        for (int c = 0; c <= userNumber; c = c + 13) {
            System.out.println(c);
        }
    }
}