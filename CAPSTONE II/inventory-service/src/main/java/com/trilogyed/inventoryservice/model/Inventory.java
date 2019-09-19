package com.trilogyed.inventoryservice.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Inventory {

    private int id;

    @Min(value = 1, message = "Product ID must be a value above zero.")
    private int productId;

    @Positive(message = "Product quantity can never be negative!")
    @Min(value = 0, message = "Product quantity cannot be a negative integer.")
    private int quantity;

    // Getters, setters, equals, hashCode, toString
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return getId() == inventory.getId() &&
                getProductId() == inventory.getProductId() &&
                getQuantity() == inventory.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductId(), getQuantity());
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}