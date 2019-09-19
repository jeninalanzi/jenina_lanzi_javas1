package com.trilogyed.retailapi.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Objects;

public class Invoice {

    private int id;
    @Positive
    @Min(value = 1, message = "Customer ID needs to be greater than zero!")
    private int customerId;
    @NotBlank
    private LocalDate purchaseDate;

    // Getters, setters, equals, hashCode, toString
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getId() == invoice.getId() &&
                getCustomerId() == invoice.getCustomerId() &&
                getPurchaseDate().equals(invoice.getPurchaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getPurchaseDate());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
