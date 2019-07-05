package exercise4;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        // initiate new array
        int[] userArray = new int[5];

        // For every index in userArray, prompt user for an integer
        // and save that integer into a variable.
        for (int a = 0; a < userArray.length; a++) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter a number: ");
            userArray[a] = Integer.parseInt(scan.nextLine());
        }

        // Print results to the user.
        System.out.format("The numbers you chose are: %d, %d, %d, %d, %d ", userArray[0], userArray[1], userArray[2], userArray[3], userArray[4]);
    }
}
