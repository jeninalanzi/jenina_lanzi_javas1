package com.company.service;

import com.company.CarApp;
import com.company.model.Car;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    // This list will be required because whenever Inventory is instantiated, it must
    // CONTSTRUCTOR OF:
        // 1. BE able to access the data structure/list of Car objects
        // 2. Prompt user with Scanner to do things within the specified methods

    // Initiate Scanner for all method use
    Scanner scan = new Scanner(System.in);

    // Create ArrayList
    private List<Car> carInventory = new ArrayList<>();

    // 1. Add() method
    public void add() {
        Car newCar = new Car();

        try {
            System.out.println("========== ADD A NEW CAR ==========");

            System.out.print("Please enter the MAKE: ");
            String newCarMake = scan.nextLine();
            newCar.setMake(newCarMake);

            System.out.print("Please enter the MODEL: ");
            String newCarModel = scan.nextLine();
            newCar.setModel(newCarModel);

            System.out.print("Please enter the COLOR of the car: ");
            String newCarColor = scan.nextLine();
            newCar.setColor(newCarColor);

            System.out.print("Please enter the YEAR of the car's manufacture (integers only): ");
            int newCarYear = Integer.parseInt(scan.nextLine());
            newCar.setYear(newCarYear);

            System.out.print("Please enter the number of MILES on the odometer (integers only): ");
            int newCarOdometerValue = Integer.parseInt(scan.nextLine());
            newCar.setOdometerValue(newCarOdometerValue);
        } catch (NumberFormatException n) {
            System.out.println("Error: Not a valid number! " + n.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Not a valid input! " + e.getMessage());
        }

        // Push the newly created Car object INSIDE List!!!!
        carInventory.add(newCar);

        // Redirect the user BACK to the controller.

        // Print out what's inside of carInventory (so far)
        System.out.println(carInventory);
        System.out.println(" ");

    }

    // 2. Delete a car
    public void delete() {
        System.out.println("========== DELETE A CAR ==========");
        System.out.println(" ");
        System.out.println(" List of Current Cars (by index):");
        // Display the current Cars in the list with their indexes.
        for (Car car : carInventory) {
            System.out.println(carInventory.indexOf(car) + " | " + car.getYear() + " " + car.getMake() + " " + car.getModel() + "  Color: " + car.getColor() + " Odometer Miles: " + car.getOdometerValue());
        }

        try {
            System.out.print("Please select a car (by its index) to delete it from the list: ");
            int indexToDelete = Integer.parseInt(scan.nextLine());
            carInventory.remove(indexToDelete);

            for (Car car : carInventory) {
                System.out.println(carInventory.indexOf(car) + " | " + car.getYear() + " " + car.getMake() + " " + car.getModel() + "  Color: " + car.getColor() + " Odometer Miles: " + car.getOdometerValue());
            }

        } catch (NumberFormatException n) {
            System.out.println("That is not a number. Please try again. ");
        }

    }

    // 3. ListAll method
    public void listAll() {
        System.out.println("========== ALL CARS | INVENTORY ==========");
        // List all cars
        for (Car car : carInventory) {
            System.out.println(" ");
            System.out.println(carInventory.indexOf(car) + " | " + car.getYear() + " " + car.getMake() + " " + car.getModel() + "   Color: " + car.getColor() + "   Odometer Miles: " + car.getOdometerValue());
        }

        // Print message in case there are none in the inventory.
        if (carInventory.size() == 0) {
            System.out.println(" ");
            System.out.println("Sorry, there is nothing in the inventory right now.");
            System.out.println("Please go back to the menu to add some cars in the inventory. \n");
            CarApp.promptUser();
        }
    }

    public void search() {
        System.out.println("========== SEARCH INVENTORY ==========");

        int userChoice;

        try {
            // Give user a list of options for search criteria.
            System.out.println("You can search by (select proper integer to choose):");
            System.out.println("[1] Make");
            System.out.println("[2] Model");
            System.out.println("[3] Year");
            System.out.println("[4] Color");
            System.out.println("[5] Less Than __ Miles");

            userChoice = Integer.parseInt(scan.nextLine());

            String userSelect;

            switch (userChoice) {
                case 1:
                    System.out.print("Search by MAKE: ");
                    userSelect = scan.nextLine();
                    filteredSearch(userSelect);
                    break;
                case 2:
                    System.out.print("Search by MODEL: ");
                    userSelect = scan.nextLine();
                    filteredSearch(userSelect);
                    break;
                case 3:
                    System.out.print("Search by YEAR: ");
                    int userYrSelect = Integer.parseInt(scan.nextLine());
                    filteredSearch(userYrSelect);
                    break;
                case 4:
                    System.out.print("Search by COLOR: ");
                    userSelect = scan.nextLine();
                    filteredSearch(userSelect);
                    break;
                case 5:
                    System.out.println("Search: Find all Cars that have driven less than __ miles (int only): ");
                    int userMilesInput = Integer.parseInt(scan.nextLine());
                    searchByMileage(userMilesInput);
                    break;
                default:
                    System.out.println("ERROR: You have entered an invalid input");
                    userChoice = CarApp.promptUser();

            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: That is not a valid number input");
        } finally {
            userChoice = CarApp.promptUser();
        }

    }

    // Filtered search overloaded methods to reuse in search method.
    public void filteredSearch(String userInput) {
        carInventory
                .stream()
                .filter(c -> c.getMake().equals(userInput))
                .forEach(c -> {
                    System.out.println("Year: " + c.getYear());
                    System.out.println("Make: " + c.getMake());
                    System.out.println("Model: " + c.getModel());
                    System.out.println("Color: " + c.getColor());
                    System.out.println("Miles on odometer: " + c.getOdometerValue());
                });
    }

    public void filteredSearch(int userInput) {
        carInventory
                .stream()
                .filter(c -> c.getMake().equals(userInput))
                .forEach(c -> {
                    System.out.println("Year: " + c.getYear());
                    System.out.println("Make: " + c.getMake());
                    System.out.println("Model: " + c.getModel());
                    System.out.println("Color: " + c.getColor());
                    System.out.println("Miles on odometer: " + c.getOdometerValue());
                });
    }

    public void searchByMileage(int userMilesInput) {
        carInventory
                .stream()
                .filter(c -> c.getOdometerValue() < userMilesInput)
                .forEach(c -> {
                    System.out.println("Year: " + c.getYear());
                    System.out.println("Make: " + c.getMake());
                    System.out.println("Model: " + c.getModel());
                    System.out.println("Color: " + c.getColor());
                    System.out.println("Miles on odometer: " + c.getOdometerValue());
                });
    }



}
