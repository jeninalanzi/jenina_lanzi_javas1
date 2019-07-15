import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        // New list
        ArrayList<Integer> newArray = new ArrayList<>();

        newArray.addAll(numbers);

        numbers.set(9, -7);

        System.out.println(numbers);
        System.out.println(newArray);
    }
}
