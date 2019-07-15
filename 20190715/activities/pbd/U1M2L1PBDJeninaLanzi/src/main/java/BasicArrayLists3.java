import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> soManyNumbers = new ArrayList<>();

        for (int a = 0; a < 1000; a++) {
            soManyNumbers.add(random.nextInt(99) + 10);
        }

        System.out.println(soManyNumbers);
    }
}
