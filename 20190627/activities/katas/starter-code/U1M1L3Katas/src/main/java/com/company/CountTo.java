package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any number: ");
        int userNumber = Integer.parseInt(scan.nextLine());

        for (int b = 0; b <= userNumber; b++) {
            System.out.println(b);
        }
    }
}
