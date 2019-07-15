import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListThereOrNot {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(50) + 1);
        }

        // display ArrayList
        System.out.println(numbers);

        // Prompt user for a number to check for instances in arrayList.
        System.out.print("Value to find: ");
        int userChoice = Integer.parseInt(scan.nextLine());

        boolean hasNumbers = numbers.contains(userChoice);

        if (hasNumbers) {
            for (int i = 0; i < 10; i++) {
                System.out.println(userChoice + " is in the ArrayList.");
            }
        } else {
            System.out.println(userChoice + " is NOT in the ArrayList.");
        }

    }
}
