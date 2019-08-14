package com.company.JeninaLanziU1Capstone.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

// Superclass for all inventory items.
public class Item {

    protected int id;

    @Digits(integer=6, fraction=2)
    protected BigDecimal price;

    protected int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        Item item = (Item) o;
        return getId() == item.getId() &&
                getQuantity() == item.getQuantity() &&
                getPrice().equals(item.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
