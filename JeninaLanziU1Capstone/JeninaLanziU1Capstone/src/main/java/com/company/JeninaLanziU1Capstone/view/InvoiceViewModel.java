package com.company.JeninaLanziU1Capstone.view;

import com.company.JeninaLanziU1Capstone.model.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {

    // Properties the user will provide.
    private int id;

    @NotEmpty(message = "Name cannot be empty!")
    private String name;

    @NotEmpty(message = "Street cannot be empty!")
    private String street;

    @NotEmpty(message = "City cannot be empty!")
    private String city;

    @NotEmpty(message = "State cannot be empty!")
    @Size(min = 2, max = 2, message = "State needs to be a valid state code.")
    private String state;

    @NotEmpty(message = "Zipcode cannot be empty!")
    private String zipcode;

    @NotEmpty(message = "Item type cannot be empty!")
    private String itemType;

    @NotNull
    private int itemId;

    @NotNull
    @Min(value = 1, message = "Quantity cannot be zero.")
    private int quantity;

    // Properties to be later obtained through business logic.
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
    private SalesTaxRate tax;
    private BigDecimal taxAmount;
    private ProcessingFee processingFee;
    private BigDecimal total;

    // Getters, setters, equals, hashCode, toString
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getSubtotal() {
        return subtotal.setScale(2, RoundingMode.HALF_UP);
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal.setScale(2, RoundingMode.HALF_UP);
    }

    public SalesTaxRate getTax() {
        return tax;
    }

    public void setTax(SalesTaxRate tax) {
        this.tax = tax;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public ProcessingFee getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(ProcessingFee processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void setTotal(BigDecimal total) {
        this.total = total.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getId() == that.getId() &&
                getItemId() == that.getItemId() &&
                getQuantity() == that.getQuantity() &&
                getName().equals(that.getName()) &&
                getStreet().equals(that.getStreet()) &&
                getCity().equals(that.getCity()) &&
                getState().equals(that.getState()) &&
                getZipcode().equals(that.getZipcode()) &&
                getItemType().equals(that.getItemType()) &&
                Objects.equals(getUnitPrice(), that.getUnitPrice()) &&
                Objects.equals(getSubtotal(), that.getSubtotal()) &&
                Objects.equals(getTax(), that.getTax()) &&
                Objects.equals(getTaxAmount(), that.getTaxAmount()) &&
                Objects.equals(getProcessingFee(), that.getProcessingFee()) &&
                Objects.equals(getTotal(), that.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getQuantity(), getUnitPrice(), getSubtotal(), getTax(), getTaxAmount(), getProcessingFee(), getTotal());
    }

    @Override
    public String toString() {
        return "InvoiceViewModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", taxAmount=" + taxAmount +
                ", processingFee=" + processingFee +
                ", total=" + total +
                '}';
    }
}
