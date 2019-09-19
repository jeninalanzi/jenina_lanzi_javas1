package com.trilogyed.retailapi.view;

import com.trilogyed.retailapi.model.InvoiceItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {
    private int id;
    private int customerId;
    private LocalDate purchaseDate;
    private List<InvoiceItem> invoiceItemsList = new ArrayList<>();

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

    public List<InvoiceItem> getInvoiceItemsList() {
        return invoiceItemsList;
    }

    public void setInvoiceItemsList(List<InvoiceItem> invoiceItemsList) {
        this.invoiceItemsList = invoiceItemsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getId() == that.getId() &&
                getCustomerId() == that.getCustomerId() &&
                getPurchaseDate().equals(that.getPurchaseDate()) &&
                getInvoiceItemsList().equals(that.getInvoiceItemsList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getPurchaseDate(), getInvoiceItemsList());
    }

    @Override
    public String toString() {
        return "InvoiceViewModel{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", purchaseDate=" + purchaseDate +
                ", invoiceItemsList=" + invoiceItemsList +
                '}';
    }
}
