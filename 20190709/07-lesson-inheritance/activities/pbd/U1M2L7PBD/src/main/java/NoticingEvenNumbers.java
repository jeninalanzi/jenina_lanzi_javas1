public class NoticingEvenNumbers {

    public static void main(String[] args) {
        for (int x = 1; x <= 20; x++) {
            if (x % 2 == 0) {
                System.out.println(x + " **");
            } else {
                System.out.println(x);
            }
        }
    }

}
