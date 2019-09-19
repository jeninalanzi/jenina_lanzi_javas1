package com.trilogyed.customerservice.dao;

import com.trilogyed.customerservice.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer addCustomer(Customer customer);

    Customer getCustomer(int id);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);
}
