import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        // Initiate Random
        Random random = new Random();

        // Declare some fortunes.
        String fortune1 = "'A pleasant surprise is waiting for you.'";
        String fortune2 = "'A light heart carries you through all the hard times.'";
        String fortune3 = "'All your hard work will soon pay off.'";
        String fortune4 = "'Courtesy is contagious.'";
        String fortune5 = "'Each day, compel yourself to do something you would rather not do.'";
        String fortune6 = "'You love Chinese food.'";
        String fortune7 = "'Your goal will be reached very soon.'";
        String fortune8 = "'Fortune Not Found: Abort, Retry, Ignore?'";

        // Generate a randomFortuneNumber by having Random generate a number between 1-8.
        int randomFortuneNumber = random.nextInt(8);

        // Assign fortunes to each value.
        if (randomFortuneNumber == 1) {
            System.out.println("Fortune cookie says: " + fortune1);
        } else if (randomFortuneNumber == 2) {
            System.out.println("Fortune cookie says: " + fortune2);
        } else if (randomFortuneNumber == 3) {
            System.out.println("Fortune cookie says: " + fortune3);
        } else if (randomFortuneNumber == 4) {
            System.out.println("Fortune cookie says: " + fortune4);
        } else if (randomFortuneNumber == 5) {
            System.out.println("Fortune cookie says: " + fortune5);
        } else if (randomFortuneNumber == 6) {
            System.out.println("Fortune cookie says: " + fortune6);
        } else if (randomFortuneNumber == 7) {
            System.out.println("Fortune cookie says: " + fortune7);
        } else if (randomFortuneNumber == 8) {
            System.out.println("Fortune cookie says: " + fortune8);
        }
    }
}
