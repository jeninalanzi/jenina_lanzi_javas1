package com.trilogyed.customerservice.dao;

import com.trilogyed.customerservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoTest {

    @Autowired
    CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        List<Customer> cList = customerDao.getAllCustomers();
        for (Customer c : cList) {
            customerDao.deleteCustomer(c.getId());
        }
    }

    @Test
    public void addGetDeleteCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Gina");
        customer.setLastName("Hendrix");
        customer.setStreet("941 E Cool Street");
        customer.setCity("Luxemborg");
        customer.setZip("21345");
        customer.setEmail("ghendrix@email.com");
        customer.setPhone("222-555-7777");

        customer = customerDao.addCustomer(customer);

        Customer customer1 = customerDao.getCustomer(customer.getId());

        assertEquals(customer1, customer);

        customerDao.deleteCustomer(customer.getId());

        customer1 = customerDao.getCustomer(customer.getId());

        assertNull(customer1);
    }

    @Test
    public void updateCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Gina");
        customer.setLastName("Hendrix");
        customer.setStreet("941 E Cool Street");
        customer.setCity("Luxemborg");
        customer.setZip("21345");
        customer.setEmail("ghendrix@email.com");
        customer.setPhone("222-555-7777");

        customer = customerDao.addCustomer(customer);

        customer.setStreet("555 E Awesome Ave");
        customer.setPhone("999-999-9999");

        customerDao.updateCustomer(customer);

        Customer customer1 = customerDao.getCustomer(customer.getId());

        assertEquals(customer1, customer);
    }

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("Gina");
        customer.setLastName("Hendrix");
        customer.setStreet("941 E Cool Street");
        customer.setCity("Luxemborg");
        customer.setZip("21345");
        customer.setEmail("ghendrix@email.com");
        customer.setPhone("222-555-7777");

        Customer customer1 = new Customer();
        customer1.setFirstName("Lucas");
        customer1.setLastName("West");
        customer1.setStreet("1000 S Main St.");
        customer1.setCity("Hamberg");
        customer1.setZip("33333");
        customer1.setEmail("lwest99@email.com");
        customer1.setPhone("111-222-4444");

        customer = customerDao.addCustomer(customer);
        customer1 = customerDao.addCustomer(customer1);

        List<Customer> allCustomers = customerDao.getAllCustomers();

        assertEquals(2, allCustomers.size());
    }

}
