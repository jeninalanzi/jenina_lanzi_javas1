package com.company;

public class Popcorn {
    // Properties
    private Product properties;

    // G/S
    public Product getProperties() {
        return properties;
    }

    public void setProperties(Product properties) {
        this.properties = properties;
    }


    // Methods
    public void eat() {
        System.out.println("Crunch crunch crunch");
    }
}
