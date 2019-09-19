package com.trilogyed.retailapi.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderViewModel {

    private int id;
    private int customerId;
    private int inventoryId;
    private LocalDate purchaseDate;
    private List<ProductViewModel> invoiceItemsList = new ArrayList<>();

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

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<ProductViewModel> getInvoiceItemsList() {
        return invoiceItemsList;
    }

    public void setInvoiceItemsList(List<ProductViewModel> invoiceItemsList) {
        this.invoiceItemsList = invoiceItemsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderViewModel that = (OrderViewModel) o;
        return getId() == that.getId() &&
                getCustomerId() == that.getCustomerId() &&
                getInventoryId() == that.getInventoryId() &&
                getPurchaseDate().equals(that.getPurchaseDate()) &&
                getInvoiceItemsList().equals(that.getInvoiceItemsList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getInventoryId(), getPurchaseDate(), getInvoiceItemsList());
    }

    @Override
    public String toString() {
        return "InvoiceViewModel{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", inventoryId=" + inventoryId +
                ", purchaseDate=" + purchaseDate +
                ", invoiceItemsList=" + invoiceItemsList +
                '}';
    }
}
