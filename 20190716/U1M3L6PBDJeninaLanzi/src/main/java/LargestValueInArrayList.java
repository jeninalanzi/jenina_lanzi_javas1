import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LargestValueInArrayList {
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        System.out.println(numbers);

        System.out.println("The largest number in the array is: " + Collections.max(numbers));;
    }
}
