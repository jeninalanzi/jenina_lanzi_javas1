import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {

        // Scanner initiate & prompt
        Scanner scan = new Scanner(System.in);
        System.out.println("I will add up the numbers you give me.");
        System.out.print("Number: ");
        int userNumber = Integer.parseInt(scan.nextLine());

        int sum = 0;
        sum+=userNumber;

        while (userNumber != 0) {
            System.out.format("The total so far is %d %n", sum);
            System.out.print("Number: ");
            userNumber = Integer.parseInt(scan.nextLine());
            sum+=userNumber;
        }
        System.out.format("The total is %d.", sum);
    }
}
