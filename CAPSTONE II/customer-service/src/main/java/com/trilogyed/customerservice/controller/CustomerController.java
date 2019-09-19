package com.trilogyed.customerservice.controller;

import com.trilogyed.customerservice.dao.CustomerDao;
import com.trilogyed.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerDao customerDao;

    // POST METHOD
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody @Valid Customer customer) {
        customerDao.addCustomer(customer);

        return customerDao.getCustomer(customer.getId());
    }


    // GET BY ID METHOD
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Customer ID needs to be greater than zero!");
        }
        return customerDao.getCustomer(id);
    }


    // GET ALL METHOD
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }


    // UPDATE METHOD
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody @Valid Customer customer, @PathVariable int id) {
        for (Customer c : customerDao.getAllCustomers()) {
            if (c.getId() == id) {
                customer.setId(id);
                customerDao.updateCustomer(customer);
                System.out.println("Customer updated successfully.");
            }
        }
    }


    // DELETE METHOD
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Customer ID must be greater than 0!");
        }
        customerDao.deleteCustomer(id);
        System.out.println("Customer successfully deleted from database.");
    }

}
