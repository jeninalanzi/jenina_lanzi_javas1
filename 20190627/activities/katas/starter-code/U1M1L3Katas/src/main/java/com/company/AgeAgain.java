package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        // Prompt user their age and save.
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your age? ");
        int userAge = scan.nextInt();

        if (userAge < 14) {
            // Prompt user their grade and store, then print to the user.
            System.out.println("What grade are you in? ");
            scan.nextLine(); // Add this to prevent lines/input being skipped
            String userGrade = scan.nextLine();
            System.out.println("Wow! " + userGrade + " grade - that sounds exciting!");
        } else if (userAge >= 14 && userAge <= 18) {
            System.out.println("Are you planning to go to college? (yes/no): ");
            scan.nextLine();
            String userAnswer = scan.nextLine();

            // Asks corresponding questions to whether the student is going to college or not.
            // Tried to add a second scan.nextLine() here but it just created a blank space - not necessary.
            switch (userAnswer) {
                case "yes":
                    System.out.println("What college are you going to?");
                    String collegeAnswer = scan.nextLine();
                    System.out.println(collegeAnswer + " is a great school!");
                    break;
                case "no":
                    System.out.println("What do you want to do after high school?");
                    String postHsAnswer = scan.nextLine();
                    System.out.println("Wow, " + postHsAnswer + " sounds like a plan!");
                    break;
                default:
                    System.out.println("That was not a valid answer.");
            }
        } else {
            // Prompt user what their job is if over 18.
            System.out.println("What is your job? ");
            scan.nextLine();
            String userJobAnswer = scan.nextLine();
            System.out.println(userJobAnswer + " sounds like a great job!");
        }
    }
}
