package com.company.JeninaLanziU1Capstone.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {

    // Customer details
    @NotNull(message = "You must supply a value for id.")
    @Size(max = 11)
    private int invoiceId;

    @NotEmpty(message = "You must supply a value for name.")
    @Size(max = 80)
    private String name;

    @NotEmpty(message = "You must supply a value for street.")
    @Size(max = 30)
    private String street;

    @NotEmpty(message = "You must supply a value for city.")
    @Size(max = 30)
    private String city;

    @NotEmpty(message = "You must supply a value for state.")
    @Size(min = 2, max = 2, message = "State must be 2 chars long (ex. FL)")
    private String state;

    @NotEmpty(message = "You must supply a value for zipcode.")
    @Size(min = 5, max = 5, message = "Zipcode must be 5 digits long.")
    private String zipcode;

    // Invoice details
    @NotEmpty(message = "You must supply a value for item type!")
    @Size(max = 20, message = "Please choose between 'Consoles', 'T-Shirts', or 'Games' only!")
    private String itemType;

    @NotNull(message = "You must supply a value for item id.")
    @Size(max = 11)
    private int itemId;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    private BigDecimal unitPrice;

    @NotNull(message = "You must supply a quantity!")
    @Size(max = 11)
    private int quantity;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    private BigDecimal subtotal;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal tax;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal processingFee;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    private BigDecimal total;

    // Getters, setters, equals, hashCode, toString
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceId() == invoice.getInvoiceId() &&
                getItemId() == invoice.getItemId() &&
                getQuantity() == invoice.getQuantity() &&
                getName().equals(invoice.getName()) &&
                getStreet().equals(invoice.getStreet()) &&
                getCity().equals(invoice.getCity()) &&
                getState().equals(invoice.getState()) &&
                getZipcode().equals(invoice.getZipcode()) &&
                getItemType().equals(invoice.getItemType()) &&
                getUnitPrice().equals(invoice.getUnitPrice()) &&
                getSubtotal().equals(invoice.getSubtotal()) &&
                getTax().equals(invoice.getTax()) &&
                getProcessingFee().equals(invoice.getProcessingFee()) &&
                getTotal().equals(invoice.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getUnitPrice(), getQuantity(), getSubtotal(), getTax(), getProcessingFee(), getTotal());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemId=" + itemId +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", processingFee=" + processingFee +
                ", total=" + total +
                '}';
    }
}
