package com.company;

public class ComputerMouse {

    // Properties
    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    // Methods from the UML
    public void move(int deltaX, int deltaY) {
        this.xPosition += deltaX;
        this.yPosition += deltaY;
    }

    public void click() {
        this.lastClickedLocation[0] = xPosition;
        this.lastClickedLocation[1] = yPosition;
    }

    // Constructor
    public ComputerMouse(String manufacturer, String model, int xPosition, int yPosition, int[]lastClickedLocation) {

    }

}
