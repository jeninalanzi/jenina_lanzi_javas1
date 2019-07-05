package exercise4;

public class ArrayFunReverseIt {
    public static void main(String[] args) {
        // Declare original array with the predetermined values.
        int[] originalArray = {1, 2, 3, 4, 5};

        // Declare a new empty array with the same length as originalArray.
        int[] reverseArray = new int[originalArray.length];

        // First, copy the values in originalArray into reversedArray.
        for (int x = 0; x < originalArray.length; x++) {
            reverseArray[x] = originalArray[x];
        }

        // Loop through till the array to swap each element
        for (int i = 0; i < reverseArray.length / 2; i++) {
            int current = reverseArray[i];
            reverseArray[i] = reverseArray[reverseArray.length -1 -i];
            reverseArray[reverseArray.length -1 -i] = current;
        }

        System.out.println(reverseArray[0]);
        System.out.println(reverseArray[1]);
        System.out.println(reverseArray[2]);
        System.out.println(reverseArray[3]);
        System.out.println(reverseArray[4]);
    }
}
