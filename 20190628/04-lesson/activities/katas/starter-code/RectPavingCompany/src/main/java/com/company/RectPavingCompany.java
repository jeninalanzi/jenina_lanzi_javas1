package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        int width = Integer.parseInt(scan.nextLine());

        System.out.print("What is the length of the driveway in feet? ");
        int length = Integer.parseInt(scan.nextLine());

        float cementCost = 0.0f;
        float framingCost = 0.0f;

        System.out.print("What is the cost of cement per square foot? ");
        cementCost = Float.parseFloat(scan.nextLine());

        System.out.print("What is the cost of framing/footers per linear foot? ");
        framingCost = Float.parseFloat(scan.nextLine()); // This line was changed because,
        // it was redefining cementCost (which is already declared on Ln20 so it was erroneously saving
        // cementCost as the framingCost per the debugger.

        int area = length * width;
        int perimeter = 2*length + 2*width; // This line was also changed. Perimeter was calculating
        // 2*length-2*width when the (-) should be a (+).

        System.out.format("The area of the driveway is %d square feet.%n", area);
        System.out.format("The perimeter of the driveway is %d linear feet.%n", perimeter); // This line was changed.
        // I just changed "square" to "linear" since we are dealing with the perimeter here.

        System.out.format("The cost of the cement is %.2f.%n", area*cementCost);
        System.out.format("The cost of the framing/footers is %.2f.%n", perimeter*framingCost); // This line was changed.
        // Old code was showing perimeter+framingCost when (+) should be (*).
        // I also reformatted the %f for these above codes as %.2f to show .00 decimals!
    }
}
