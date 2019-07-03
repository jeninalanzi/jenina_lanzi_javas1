package com.company;

public class Radio {

    // Properties
    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    // Radio constructor
    public Radio(String manufacturer, String model, int numSpeakers, String station, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeakers = numSpeakers;
        this.station = station;
        this.volume = volume;
        this.powered = powered;
    }

    // Method specified in UML diagram
    public void togglePower() {
        this.powered = !powered;
    }

    // Getters/setters
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumSpeakers() {
        return numSpeakers;
    }

    public void setNumSpeakers(int numSpeaker) {
        this.numSpeakers = numSpeaker;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

}
