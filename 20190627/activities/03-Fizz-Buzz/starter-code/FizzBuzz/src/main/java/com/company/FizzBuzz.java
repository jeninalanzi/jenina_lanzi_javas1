package com.company;

public class FizzBuzz {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            // If divisible by both 3 and 5, print "FIZZBUZZ"
            if ((i%15) == 0) {
                System.out.println("FIZZBUZZ");
            }
            // If divisible by 3, print "FIZZ"
            else if ((i%3) == 0) {
                System.out.println("FIZZ");
            }
            // If divisible by 5, print "BUZZ"
            else if ((i%5) == 0) {
                System.out.println("BUZZ");
            }
            // If neither conditions work, just print number
            else {
                System.out.println(i);
            }
        }
    }
}
