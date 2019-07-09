package com.company;

public class Gum {
    // Properties
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
    public void chew() {
        System.out.println("Chew");
    }

    public void blowBubble() {
        System.out.println("You blew a bubble!");
    }
}
