package com.company;

public class TV {
    // Properties
    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    // Constructor for TV
    public TV(String manufacturer, String model, int screenSize, String channel, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.screenSize = screenSize;
        this.channel = channel;
        this.volume = volume;
        this.powered = powered;
    }

    // Method from UML diagram
    public void togglePower() {
        this.powered = !powered;
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

    public int getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isPowered() {
        return this.powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }
}
