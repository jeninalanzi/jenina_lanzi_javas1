import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingValueInAnArrayList {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(50) + 1);
        }

        System.out.println("ArrayList: " + numbers + "\n");

        // Prompt user for a number
        System.out.print("Value to find: ");
        int userChoice = Integer.parseInt(scan.nextLine());

//        System.out.println(userChoice);

        // Search through arrayList to see if the user's choice matches any instances.
        for (int i = 0; i < 10; i++) {
            if (numbers.get(i) == userChoice) {
                System.out.println(userChoice + " is in the arrayList.");
            }
        }
    }
}
