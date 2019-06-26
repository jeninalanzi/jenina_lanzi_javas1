package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user to enter firstName & save the input by using nextLine()
        System.out.print("Enter your first name: ");
        String firstName = scan.nextLine();

        // Prompt user to enter lastName & save the input by using nextLine()
        System.out.print("Enter your last name: ");
        String lastName = scan.nextLine();

        // Prompt user to enter email & save the input by using nextLine()
        System.out.print("Enter your email: ");
        String email = scan.nextLine();

        // Prompt user to enter Twitter handle & save the input by using nextLine()
        System.out.print("Enter your Twitter handle: ");
        String twitterHandle = scan.nextLine();

        // Prompt user to enter age & save the input by using nextInt()
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(scan.nextLine());

        // Prompt user to enter country & save the input by using nextLine()
        System.out.print("Enter your country: ");
        String country = scan.nextLine();

        // Prompt user to enter profession & save the input by using nextLine()
        System.out.print("Enter your profession: ");
        String profession = scan.nextLine();

        // Prompt user to enter favoriteOS & save the input by using nextLine()
        System.out.print("Enter your favorite operating system: ");
        String favoriteOS = scan.nextLine();

        // Prompt user to enter faveProgLang & save the input by using nextLine()
        System.out.print("Enter your favorite programming language: ");
        String faveProgLang = scan.nextLine();

        // Prompt user to enter faveCompScientist & save the input by using nextLine()
        System.out.print("Enter your favorite computer scientist: ");
        String faveCompScientist = scan.nextLine();

        // Prompt user to enter faveKeyShortcut & save the input by using nextLine()
        System.out.print("Enter your favorite keyboard shortcut: ");
        String faveKeyShortcut = scan.nextLine();

        // Prompt user a question & save the answer by using nextLine()
        System.out.print("Have you ever built your own computer? ");
        String answer1 = scan.nextLine();

        // Prompt user another question & save the answer by using nextLine()
        System.out.print("If you could be any superhero, who would it be? ");
        String answer2 = scan.nextLine();


        // Output
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Twitter handle: " + twitterHandle);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
        System.out.println("Profession: " + profession);
        System.out.println("Favorite operating system: " + favoriteOS);
        System.out.println("Favorite programming language: " + faveProgLang);
        System.out.println("Favorite computer scientist: " + faveCompScientist);
        System.out.println("Favorite keyboard shortcut: " + faveKeyShortcut);
        System.out.println("Have you ever built your own computer? " + answer1);
        System.out.println("If you could be any superhero, who would it be? " + answer2);

    }
}
