import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(10);


        for (int i = 0; i < 10 ; i++) {
            numbers.add(-113);
        }
        for (int a = 0; a < numbers.size(); a++) {
            System.out.println("Slot " + a + " contains a " + numbers.get(a));
        }
    }
}
