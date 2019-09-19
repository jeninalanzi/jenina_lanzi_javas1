package com.trilogyed.retailapi.view;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductViewModel {

    private int invoiceId;
    private int productId;
    private String productName;
    private String productDescription;
    private int quantity;
    private BigDecimal price;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductViewModel that = (ProductViewModel) o;
        return getInvoiceId() == that.getInvoiceId() &&
                getProductId() == that.getProductId() &&
                getQuantity() == that.getQuantity() &&
                getProductName().equals(that.getProductName()) &&
                getProductDescription().equals(that.getProductDescription()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getProductId(), getProductName(), getProductDescription(), getQuantity(), getPrice());
    }

    @Override
    public String toString() {
        return "ProductViewModel{" +
                "invoiceId=" + invoiceId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
