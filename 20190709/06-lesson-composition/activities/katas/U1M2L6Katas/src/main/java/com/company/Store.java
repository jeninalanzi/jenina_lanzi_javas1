package com.company;

public class Store {

    // Some common properties of any Store type.
    private String name;
    private double sqFt;
    private Cash balance;
    private int productInventory;

    // Getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSqFt() {
        return sqFt;
    }

    public void setSqFt(double sqFt) {
        this.sqFt = sqFt;
    }

    public Cash getBalance() {
        return balance;
    }

    public void setBalance(Cash balance) {
        this.balance = balance;
    }

}
