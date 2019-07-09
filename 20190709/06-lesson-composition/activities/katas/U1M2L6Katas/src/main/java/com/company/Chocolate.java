package com.company;

public class Chocolate {
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
        System.out.println("This is delicious.");
    }

    public void melt() {
        System.out.println("Oh no, it's all melted.");
    }
}
