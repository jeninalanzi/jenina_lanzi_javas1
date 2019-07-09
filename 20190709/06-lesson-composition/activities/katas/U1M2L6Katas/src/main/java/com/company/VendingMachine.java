package com.company;

public class VendingMachine {

    // Properties (a store type)
    private Store properties;

    // G/S
    public Store getProperties() {
        return properties;
    }

    public void setProperties(Store properties) {
        this.properties = properties;
    }

    // Unique methods to VendingMachine.
    public double getChange(double payment, Product product) {
        double change = product.getPrice() - payment;
        return change;
    }

    public void insertCoin(double coin, Product product) {
        double sum;
        coin++;
        sum = coin;

        if (sum == product.getPrice()) {
            System.out.println("You have successfully purchased!");
            product.buy(1);
        }
    }
}
