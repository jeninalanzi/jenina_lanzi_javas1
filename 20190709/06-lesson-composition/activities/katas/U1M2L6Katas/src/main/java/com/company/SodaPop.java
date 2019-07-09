package com.company;

public class SodaPop {
    // Properties
    private Product properties;
    private String flavor;
    private boolean hasCaffeine;
    private double flOz;

    // G/S
    public Product getProperties() {
        return properties;
    }

    public void setProperties(Product properties) {
        this.properties = properties;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public boolean isHasCaffeine() {
        return hasCaffeine;
    }

    public void setHasCaffeine(boolean hasCaffeine) {
        this.hasCaffeine = hasCaffeine;
    }

    // Methods
    public double drink(double flOz) {
       double remainder = this.flOz - flOz;
       return remainder;
    }

    public boolean wakeUp(boolean hasCaffeine) {
        return (this.hasCaffeine);
    }
}
