package com.trilogyed.customerservice.dao;

import com.trilogyed.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoJdbcTemplateImpl implements CustomerDao {

    // Prepared statements
    private static final String INSERT_CUSTOMER_SQL = "insert into customer (first_name, last_name, street, city, zip, email, phone) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_CUSTOMER_SQL = "select * from customer where customer_id = ?";
    private static final String GET_ALL_CUSTOMERS_SQL = "select * from customer";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set first_name = ?, last_name = ?, street = ?, city = ?, zip = ?, email = ?, phone = ? where customer_id = ?";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?";

    // Constructor dependency injection
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Implement ALL methods!!

    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
        jdbcTemplate.update(INSERT_CUSTOMER_SQL,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getCity(),
                customer.getZip(),
                customer.getEmail(),
                customer.getPhone());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        customer.setId(id);

        return customer;
    }

    @Override
    public Customer getCustomer(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_CUSTOMER_SQL, this::mapRowToCustomer, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(GET_ALL_CUSTOMERS_SQL, this::mapRowToCustomer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(UPDATE_CUSTOMER_SQL,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getCity(),
                customer.getZip(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getId());
    }

    @Override
    public void deleteCustomer(int id) {
        jdbcTemplate.update(DELETE_CUSTOMER_SQL, id);
    }


    // private rowMapper method
    private Customer mapRowToCustomer(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("customer_id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setStreet(rs.getString("street"));
        customer.setCity(rs.getString("city"));
        customer.setZip(rs.getString("zip"));
        customer.setEmail(rs.getString("email"));
        customer.setPhone(rs.getString("phone"));
        return customer;
    }


}
