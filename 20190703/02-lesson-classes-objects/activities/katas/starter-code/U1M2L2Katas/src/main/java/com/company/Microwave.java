package com.company;

public class Microwave {

    // Properties
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    // Microwave constructor
    public Microwave(String manufacturer, String model, int secondsLeft, String time, boolean running) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.secondsLeft = secondsLeft;
        this.time = time;
        this.running = running;
    }

    // Methods specified in UML diagram.
    public void start(int secondsLeft) {
        this.secondsLeft = secondsLeft;
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }

    public void clear() {
        this.secondsLeft = 0;
    }

    // Getters and setters
    public String getManufacturer() {
        return this.manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getSecondsLeft() {
        return this.secondsLeft;
    }
    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRunning() {
        return this.running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
}
