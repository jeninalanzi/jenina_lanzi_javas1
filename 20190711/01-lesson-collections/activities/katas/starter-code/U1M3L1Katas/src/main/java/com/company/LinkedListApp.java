package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {

    public static int total (List<Integer> numbers) {

        int sum = 0;
        for(Integer num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (List<Integer> numbers) {

        Integer sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(List<String> strings) {

        String temp = strings.get(0);
        strings.set(0, strings.get(strings.size() -1));
        strings.set(strings.size() -1, temp);

        return strings;
    }

    public static List<Integer> reverse(List<Integer> numbers) {
        List<Integer> reversed = new LinkedList<>();

        // This will decrement DOWN the numbers List INSTEAD of incrementing!
        // SO cool learning this!!!!
        for (int i = numbers.size() -1; i >= 0; i--) {
            reversed.add(numbers.get(i));
        }

        return reversed;
    }

    public static List<Integer> lessThanFive(List<Integer> numbers) {

        // Calculates if List is null or not.
        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if (numLessThanFive == 0) {
            return null;
        }

        // Begin new lessThan List.
        List<Integer> lessThan = new LinkedList<>();

        for (Integer x : numbers) {
            if (x < 5) {
                lessThan.add(x);
            }
        }

        return lessThan;
    }
}
