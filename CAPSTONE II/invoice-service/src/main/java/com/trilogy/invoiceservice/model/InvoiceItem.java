package com.trilogy.invoiceservice.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {

    private int id;

    @Positive
    @Min(value = 1, message = "Invoice ID needs to be greater than zero!")
    private int invoiceId;

    @Positive
    @Min(value = 1, message = "Inventory ID needs to be greater than zero!")
    private int inventoryId;

    @Positive
    @Min(value = 0, message = "Quantity cannot be a negative number or invalid input value.")
    private int quantity;

    @Digits(integer = 7, fraction = 2)
    private BigDecimal unitPrice;

    // Getters, setters, equals, hashCode, toString
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return getId() == that.getId() &&
                getInvoiceId() == that.getInvoiceId() &&
                getInventoryId() == that.getInventoryId() &&
                getQuantity() == that.getQuantity() &&
                getUnitPrice().equals(that.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInvoiceId(), getInventoryId(), getQuantity(), getUnitPrice());
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "id=" + id +
                ", invoiceId=" + invoiceId +
                ", inventoryId=" + inventoryId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
