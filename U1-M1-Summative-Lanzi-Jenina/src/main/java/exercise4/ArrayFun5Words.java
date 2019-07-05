package exercise4;

import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        // Initiate a new string array.
        String[] funArray = new String[5];

        // For every element in the new array, prompt the user
        // to input a word and assign into an array index.
        for (int b = 0; b < funArray.length; b++) {
            // Scanner & prompt
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a word: ");
            funArray[b] = scan.nextLine();
        }

        // Print the user's words to the screen.
        System.out.println(funArray[0]);
        System.out.println(funArray[1]);
        System.out.println(funArray[2]);
        System.out.println(funArray[3]);
        System.out.println(funArray[4]);
    }
}
