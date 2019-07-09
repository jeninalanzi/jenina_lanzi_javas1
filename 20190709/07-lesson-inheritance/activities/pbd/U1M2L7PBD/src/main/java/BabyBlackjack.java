import java.util.Random;

public class BabyBlackjack {

    public static void main(String[] args) {

        // Initiate Random
        Random random = new Random();

        // Generate 2 random card draws for User, then total.
        int card1 = random.nextInt(10) + 1;
        int card2 = random.nextInt(10) + 1;
        int userTotal = card1 + card2;

        // Print results to console.
        System.out.println("Baby Blackjack! \n");
        System.out.format("You drew %d and %d. %n", card1, card2);
        System.out.format("Your total is %d. %n", userTotal);
        System.out.println(" ");

        // Generate dealer's random cards and their total.
        int dealerCard1 = random.nextInt(10) + 1;
        int dealerCard2 = random.nextInt(10) + 1;
        int dealerTotal = dealerCard1 + dealerCard2;

        // Print dealer's results to console.
        System.out.format("The dealer has %d and %d. %n", dealerCard1, dealerCard2);
        System.out.format("Dealer's total is %d. %n", dealerTotal);
        System.out.println(" ");

        // Compare results to display who wins.
        if (userTotal > dealerTotal) {
            System.out.println("YOU WIN!");
        } else if ( dealerTotal > userTotal) {
            System.out.println("Dealer wins.");
        }

    }
}
