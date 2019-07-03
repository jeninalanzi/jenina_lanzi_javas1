package com.company;

import java.sql.SQLOutput;

public class App {

    // Each method takes in NO arguments and returns its respective Object.

    public static TV createTV() {
        TV tv = new TV("Zenith", "U2121H", 83, "NBC", 55, false);

        System.out.println("New TV!");
        System.out.println("Manufacturer: " + tv.getManufacturer());
        System.out.println("Model: " + tv.getModel());
        System.out.println("Screen size: " + tv.getScreenSize());
        System.out.println("Channel: " + tv.getChannel());
        System.out.println("Volume: " + tv.getVolume());
        System.out.println("Is it powered on? " + tv.isPowered());

        return tv;
    }

    public static Radio createRadio() {
        Radio radio = new Radio("Sony", "V32", 2, "WUNV", 30, true);

        System.out.println("New Radio!");
        System.out.println("Manufacturer: " + radio.getManufacturer());
        System.out.println("Model: " + radio.getModel());
        System.out.println("Number of speakers: " + radio.getNumSpeakers());
        System.out.println("Station: " + radio.getStation());
        System.out.println("Volume: " + radio.getVolume());
        System.out.println("Is it powered on? " + radio.isPowered());

        return radio;
    }

    public static Microwave createMicrowave() {
        Microwave micro = new Microwave("Haier", "X1200w", 45, "12:00", false);

        System.out.println("New Microwave!");
        System.out.println("Manufacturer: " + micro.getManufacturer());
        System.out.println("Model: " + micro.getModel());
        System.out.println("Seconds left: " + micro.getSecondsLeft());
        System.out.println("Is the microwave running? " + micro.isRunning());

        return micro;
    }

    public static CoffeeMaker createCoffeeMaker() {
        CoffeeMaker cm = new CoffeeMaker("Sunbeam", "C12", 12, 8, true);

        System.out.println("New Coffee Maker!");
        System.out.println("Manufacturer: " + cm.getManufacturer());
        System.out.println("Model: " + cm.getModel());
        System.out.println("Size of carafe: " + cm.getCarafeSize());
        System.out.println("Is the microwave running? " + cm.isPowered());

        return cm;
    }

    public static Car createCar() {
        Car newCar = new Car("Honda", "Accord", "Sedan", "Blue", "2.6L V6", "CVT", 4, 31.7, 25218);

        System.out.println("New Car!");
        System.out.println("It's a new " + newCar.getMake() + "!");
        System.out.println("The model: " + newCar.getModel());
        System.out.println("Type of car: " + newCar.getType());
        System.out.println("Color: " + newCar.getColor());
        System.out.println("It has a " + newCar.getEngine() + " engine.");
        System.out.println("Transmission: " + newCar.getTransmission());
        System.out.println("Number of doors: " + newCar.getNumDoors());
        System.out.println("MPG: " + newCar.getMpg());
        System.out.println("Miles driven so far: " + newCar.getMilesDriven());

        return newCar;
    }

    public static ComputerMouse createComputerMouse() {
        ComputerMouse mousey = new ComputerMouse("Razer", "Naga", 960, 540, new int[2]);
        // I realized at the end of creating this code, that prints were not necessary to pass the test.

        return mousey;
    }


}
