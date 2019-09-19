package com.trilogyed.customerservice.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Customer {

    private int id;

    @NotEmpty(message = "You cannot leave first name blank.")
    @Size(max = 50, message = "First name can be a maximum of 50 chars long!")
    private String firstName;

    @NotEmpty(message = "You cannot leave last name blank.")
    @Size(max = 50, message = "Last name can be a maximum of 50 chars long!")
    private String lastName;

    @NotEmpty(message = "You cannot leave street blank!")
    @Size(max = 50, message = "Street can be a maximum of 50 chars long!")
    private String street;

    @NotEmpty(message = "You cannot leave city blank.")
    @Size(max = 50, message = "City can be a maximum of 50 chars long!")
    private String city;

    @NotEmpty(message = "You cannot leave zipcode blank.")
    @Size(max = 10, message = "Zipcode can be a maximum of 10 chars long!")
    private String zip;

    @NotEmpty(message = "You cannot leave email blank.")
    @Size(max = 75, message = "First name can be a maximum of 75 chars long!")
    private String email;

    @NotEmpty(message = "You cannot leave phone number blank.")
    @Size(max = 20, message = "Phone number can be a maximum of 20 chars long!")
    private String phone;

    // Getters, setters, equals, hashCode, hashCode
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() &&
                getFirstName().equals(customer.getFirstName()) &&
                getLastName().equals(customer.getLastName()) &&
                getStreet().equals(customer.getStreet()) &&
                getCity().equals(customer.getCity()) &&
                getZip().equals(customer.getZip()) &&
                getEmail().equals(customer.getEmail()) &&
                getPhone().equals(customer.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getStreet(), getCity(), getZip(), getEmail(), getPhone());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
