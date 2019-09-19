package com.trilogy.invoiceservice.dao;

import com.trilogy.invoiceservice.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {

    // Prepared statements
    private static final String INSERT_INVOICE_SQL = "insert into invoice (customer_id, purchase_date) values (?, ?)";
    private static final String GET_INVOICE_SQL = "select * from invoice where invoice_id = ?";
    private static final String GET_ALL_INVOICES_SQL = "select * from invoice";
    private static final String GET_INVOICES_BY_CUSTOMER_ID = "select * from invoice where customer_id = ?";
    private static final String UPDATE_INVOICE_SQL = "update invoice set customer_id = ?, purchase_date = ? where invoice_id = ?";
    private static final String DELETE_INVOICE_SQL = "delete from invoice where invoice_id = ?";

    // Dependency constructor injection
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Implement all methods
    @Override
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getCustomerId(),
                invoice.getPurchaseDate());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        invoice.setId(id);
        return invoice;
    }

    @Override
    public Invoice getInvoice(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_INVOICE_SQL, this::mapRowToInvoice, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(GET_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }

    @Override
    public List<Invoice> getInvoicesByCustomerId(int id) {
        return jdbcTemplate.query(GET_INVOICES_BY_CUSTOMER_ID, this::mapRowToInvoice, id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE_SQL,
                invoice.getCustomerId(),
                invoice.getPurchaseDate(),
                invoice.getId());
    }

    @Override
    public void deleteInvoice(int id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);
    }

    // private rowMapper method
    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setId(rs.getInt("invoice_id"));
        invoice.setCustomerId(rs.getInt("customer_id"));
        invoice.setPurchaseDate(rs.getDate("purchase_date").toLocalDate());
        return invoice;
    }
}
