package com.company;

public class CoffeeMaker {

    // Properties
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    // Constructor for CoffeeMaker
    public CoffeeMaker(String manufacturer, String model, int carafeSize, int cupsLeft, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafeSize;
        this.cupsLeft = cupsLeft;
        this.powered = powered;
    }

    // Methods in UML diagram
    public void brew() {
        if(isPowered() == true) {
            this.cupsLeft = getCarafeSize();
        }
    }

    public void pourCoffee(int numCups) {
        if (getCupsLeft() > numCups) {
            this.cupsLeft = getCupsLeft() - numCups;
        } else {
            this.cupsLeft = 0;
        }
    }

    // Getter/setter methods (some will also be used in the methods above)
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

    public int getCarafeSize() {
        return this.carafeSize;
    }

    public void setCarafeSize(int carafeSize) {
        this.carafeSize = carafeSize;
    }

    public int getCupsLeft() {
        return this.cupsLeft;
    }

    public void setCupsLeft(int cupsLeft) {
        this.cupsLeft = cupsLeft;
    }

    public boolean isPowered() {
        return this.powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

}
