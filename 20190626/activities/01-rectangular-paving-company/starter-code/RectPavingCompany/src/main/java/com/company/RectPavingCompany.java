package com.company;

import java.util.Scanner;

import java.text.DecimalFormat;

public class RectPavingCompany {

    public static void main(String[] args) {
        // VERSION 1:
        System.out.println("---------------------------VERSION 1-----------------------------");

        // Helps us take in user input
        Scanner scan = new Scanner(System.in);

        // 1. Prompt user for width of the driveway as an integer (in feet)
        System.out.println("What is the width of the driveway (in feet)? ");

        // This variable takes the user's input for 'width' and parses it as an integer:
        int width = Integer.parseInt(scan.nextLine());

        // 2. Prompt user for length of the driveway as an integer (in feet)
        System.out.println("What is the length of the driveway (in feet)?");

        // This variable takes the user's input for 'length' and parses it as an integer:
        int length = Integer.parseInt(scan.nextLine());

        // 3. Calculate and display the area of the driveway.
        int area = width * length;
        System.out.format("The area of the driveway is %d square feet.%n", area);

        // 4. Calculate and display the perimeter of the driveway.
        int perimeter = (width + length) * 2;
        System.out.format("The perimeter of the driveway is %d linear feet.%n", perimeter);

        // 5. Calculate the costs of the driveway:
        float cementCost = 12.50f;
        System.out.format("The cost of the cement at $12.50/sq ft is: $ %f.%n", cementCost*area);

        // 6. Calculate the costs of the driveway:
        float ffPrice = 8.25f;
        System.out.format("The cost for the framing/footers at $8.25/linear ft is $ %f.%n", ffPrice*perimeter);
        System.out.println(" ");

        // VERSION 2:
        System.out.println("---------------------------VERSION 2-----------------------------");

        // 7. Prompt user for the cost of the cement and show them the subtotal cost:
        System.out.println("What is the cost of the cement? ");
        float userCementCost = Float.parseFloat(scan.nextLine());
        System.out.format("The cost for the cement is $ %f.%n", userCementCost*area);
        System.out.println(" ");

        // 8. Prompt user for the cost of the framing/footers and show them the subtotal cost:
        System.out.println("What is the cost of the framing/footers? ");
        float userFramingCost = Float.parseFloat(scan.nextLine());
        System.out.format("The cost for framing and footers is $ %f.%n", userFramingCost*perimeter);
        System.out.println(" ");

        // 9. Add total cost of driveway as defined by the user's values
        float totalCost = userCementCost*area + userFramingCost*perimeter;
        System.out.format("The TOTAL cost of the driveway is: $ %f", totalCost);
    }
}
