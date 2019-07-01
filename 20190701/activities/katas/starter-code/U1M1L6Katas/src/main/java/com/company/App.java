package com.company;

import java.util.Scanner;

public class App {

    // 1. Total method (pass)
    public static int total(int[] numbers) {
        int sum = 0;
        // For every element in "numbers" array, add that number to the "sum."
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    // 2. TotalOdd method (pass)
    public static int totalOdd(int[] numbers) {
        int sumOfOdd = 0;
        // For every number, check to see if odd (by seeing that it is NOT even).
        for (int a = 0; a < numbers.length; a++) {
            if (a % 2 != 0) {
                sumOfOdd += numbers[a];
            }
        }
        return sumOfOdd;
    }

    // 3. TotalEven method (pass)
    public static int totalEven(int[] numbers) {
        int sumOfEven = 0;
        // For every number, check to see if even.
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                sumOfEven += numbers[i];
            }
        }
        return sumOfEven;
    }

    // 4. 2ndLargestNumber method (pass)
    public static int secondLargestNumber(int[] numbers) {
        // Declare variables for later use.
        int first;
        int second;

        // First, compare the first 2 indexes to assign to "first" and "second."
        if (numbers[0] > numbers[1]) {
            first = numbers[0];
            second = numbers[1];
        } else {
            first = numbers[1];
            second = numbers[0];
        }

        // Next, loop through other numbers in the array, if any.
        for (int b = 0; b < numbers.length; b++) {
            // If element is larger than first, reassign the old number
            // in "first" to "second," then new element becomes "first.
            if (numbers[b] > first) {
                second = first;
                first = numbers[b];
            } else if (numbers[b] < first && numbers[b] > second) {
                // If the element is smaller than first AND larger
                // than second, then assign that number to second.
                second = numbers[b];
            }
        }
        return second;
    }

    // 5. SwapFirstAndLast method (pass)
    public static String[] swapFirstAndLast(String[] array) {
        // Declare new array to return later.
        String[] wordList = new String[array.length];

        // For-loop to copy array values into wordList.
        for (int i = 0; i < array.length; i++) {
            wordList[i] = array[i];
        }

        // Assign index-0 value from wordList to a new variable, "first."
        String first = wordList[0];

        // Reassign the index-0 value with the LAST value (length-1)
        wordList[0] = wordList[wordList.length - 1];

        // Reassign the index-last value with the value of "first"
        wordList[wordList.length - 1] = first;

        // Return
        return wordList;


    }


    // 6. Reverse method (pass)
    public static int[] reverse(int[] array) {
        // Initiate new array
        int[] reversedArray = new int[array.length];

        // Copy the contents of array into reversedArray.
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[i];
        }

        // Loop through, up until the array's midpoint, to swap elements.
        for (int i = 0; i < reversedArray.length / 2; i++) {
            int current = reversedArray[i];
            reversedArray[i] = reversedArray[reversedArray.length - 1 - i];
            reversedArray[reversedArray.length - 1 - i] = current;
        }

        // Return
        return reversedArray;
    }


    // 7. ConcatenateString method (pass)
    public static String concatenateString(String[] array) {
        // Initiate a string variable to later return.
        String oneBigWord;

        // First, assign the element at index-0 to oneBigWord.
        oneBigWord = array[0];

        // Then, for-loop from the next element to the last to add onto oneBigWord.
        for (int i = 1; i < array.length; i++) {
            oneBigWord += array[i];
        }
        return oneBigWord;
    }

    // 8. Every3rd method
    public static int[] everyThird(int[] numbers) {
        int newArraySize = 0;
        for (int i = 2; i < numbers.length; i+=3) {
            newArraySize++;
            break;
        }
        int finalArraySize = newArraySize;

        int[] everyThird = new int[finalArraySize];

        for (int i = 2; i < numbers.length; i+=3) {
            everyThird[i] = numbers[i];
        }
        return everyThird;
    }





    // 9. LessThan5 method


}
