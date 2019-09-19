package com.trilogyed.retailapi.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private int id;

    @NotEmpty(message = "You cannot leave product name blank!")
    @Size(max = 50, message = "Product name can be up to 50 chars long.")
    private String productName;

    @NotEmpty(message = "You cannot leave product description empty!")
    @Size(max = 255, message = "Product description can be up to 255 chars long.")
    private String productDescription;

    @NotEmpty(message = "You cannot have an empty list price.")
    @Digits(integer=7, fraction=2)
    private BigDecimal listPrice;

    @NotEmpty(message = "You cannot have an empty unit cost.")
    @Digits(integer=7, fraction=2)
    private BigDecimal unitCost;

    // Getters, setters, equals, hashCode, toString
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                getProductName().equals(product.getProductName()) &&
                getProductDescription().equals(product.getProductDescription()) &&
                getListPrice().equals(product.getListPrice()) &&
                getUnitCost().equals(product.getUnitCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getProductDescription(), getListPrice(), getUnitCost());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", listPrice=" + listPrice +
                ", unitCost=" + unitCost +
                '}';
    }
}
