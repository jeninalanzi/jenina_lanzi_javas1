package com.company;

public class Chips {
    private Product properties;
    private String flavor;

    // G/S
    public Product getProperties() {
        return properties;
    }

    public void setProperties(Product properties) {
        this.properties = properties;
    }

    // Methods
    public void eat() {
        System.out.println("Crunch crunch");
    }
}
