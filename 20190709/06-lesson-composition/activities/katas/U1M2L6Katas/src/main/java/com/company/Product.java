package com.company;

public class Product {

    // POJO
    private String brandName;
    private String type;
    private double price;
    private int quantity;

    // Constructor
    public Product(String brandName, String type, double price, int quantity) {
        this.brandName = brandName;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters & setters
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void buy(int quantity) {
        this.quantity =-1;
    }

}
