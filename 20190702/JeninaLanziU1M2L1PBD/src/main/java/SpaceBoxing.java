import java.sql.SQLOutput;
import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {

        // Initiate the gravity values for each planet.
        double venus = 0.78;
        double mars = 0.39;
        double jupiter = 2.65;
        double saturn = 1.17;
        double uranus = 1.05;
        double neptune = 1.23;

        // Initiate scanner
        Scanner scan = new Scanner(System.in);

        // Prompt Julio Cesar Chavez Mark VII (or the user) for his current earth weight.
        System.out.print("Please enter your current earth weight: ");
        double userEarthWeight = Double.parseDouble(scan.nextLine());

        System.out.println("User's current weight is: " + userEarthWeight);

        // Show user a choice of planets.
        System.out.println(" ");
        System.out.println("I have information for the following planets:");
        System.out.println("    1. Venus     2. Mars     3. Jupiter");
        System.out.println("    4. Saturn    5. Uranus   6. Neptune");

        // Prompt user for their planet choice:
        System.out.print("Which planet are you visiting? ");
        int userChoice = Integer.parseInt(scan.nextLine());

        // initialize targetWeight.
        double targetWeight = 0;

        // Loop through each choice.
        if (userChoice == 1) {
            targetWeight = userEarthWeight*venus;
        } else if (userChoice == 2) {
            targetWeight = userEarthWeight*mars;
        } else if (userChoice == 3) {
            targetWeight = userEarthWeight*jupiter;
        } else if (userChoice == 4) {
            targetWeight = userEarthWeight*saturn;
        } else if (userChoice == 5) {
            targetWeight = userEarthWeight*uranus;
        } else if (userChoice == 6) {
            targetWeight = userEarthWeight*neptune;
        }

        // Print the result to user.
        System.out.printf("Your weight would be %.2f pounds on that planet.", targetWeight);
    }

}
