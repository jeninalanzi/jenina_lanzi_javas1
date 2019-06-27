package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any number: ");
        int userChoice = Integer.parseInt(scan.nextLine());

        for (int a = 0; a <= userChoice; a = a+2) {
            System.out.println(a);
        }
    }
}
