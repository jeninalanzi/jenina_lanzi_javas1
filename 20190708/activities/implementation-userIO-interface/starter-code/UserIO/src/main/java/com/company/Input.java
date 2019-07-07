package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {

    public int readInt(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        int userInt = Integer.parseInt(scan.nextLine());
        return userInt;
    }

    public long readLong(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        long userLong = Long.parseLong(scan.nextLine());
        return userLong;
    }

    public double readDouble(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        double userDouble = Double.parseDouble(scan.nextLine());
        return userDouble;
    }

    public float readFloat(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        float userFloat = Float.parseFloat(scan.nextLine());
        return userFloat;
    }

    public String readString(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        String userString = scan.nextLine();
        return userString;
    }
}
