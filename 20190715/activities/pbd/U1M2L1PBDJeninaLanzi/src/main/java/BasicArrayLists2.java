import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {

    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        System.out.println("ArrayList: " + numbers);
    }
}
