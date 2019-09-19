package com.trilogy.invoiceservice.dao;

import com.trilogy.invoiceservice.model.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao {

    // Prepared statements
    private static final String INSERT_INVOICE_ITEM_SQL = "insert into invoice_item (invoice_id, inventory_id, quantity, unit_price) values (?, ?, ?, ?)";
    private static final String GET_INVOICE_ITEM_SQL = "select * from invoice_item where invoice_item_id = ?";
    private static final String GET_ALL_INVOICE_ITEMS = "SELECT * FROM invoice_item";
    private static final String GET_INVOICE_ITEMS_BY_INVOICE_SQL = "select * from invoice_item where invoice_id = ?";
    private static final String UPDATE_INVOICE_ITEM_SQL = "update invoice_item set invoice_id = ?, inventory_id = ?, quantity = ?, unit_price = ? where invoice_item_id = ?";
    private static final String DELETE_INVOICE_ITEM_SQL = "delete from invoice_item where invoice_item_id = ?";

    // Constructor dependency injection
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceItemDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Implement all methods
    @Override
    public InvoiceItem addInvoiceItem(InvoiceItem item) {
        jdbcTemplate.update(INSERT_INVOICE_ITEM_SQL,
                item.getInvoiceId(),
                item.getInventoryId(),
                item.getQuantity(),
                item.getUnitPrice());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        item.setId(id);
        return item;
    }

    @Override
    public InvoiceItem getInvoiceItem(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_INVOICE_ITEM_SQL, this::mapRowToInvoiceItem, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItems() {
        return jdbcTemplate.query(GET_ALL_INVOICE_ITEMS, this::mapRowToInvoiceItem);
    }

    @Override
    public List<InvoiceItem> getInvoiceItemsByInvoice(int id) {
        return jdbcTemplate.query(GET_INVOICE_ITEMS_BY_INVOICE_SQL, this::mapRowToInvoiceItem, id);
    }

    @Override
    public void updateInvoiceItem(InvoiceItem item) {
        jdbcTemplate.update(UPDATE_INVOICE_ITEM_SQL,
                item.getInvoiceId(),
                item.getInventoryId(),
                item.getQuantity(),
                item.getUnitPrice(),
                item.getId());
    }

    @Override
    public void deleteInvoiceItem(int id) {
        jdbcTemplate.update(DELETE_INVOICE_ITEM_SQL, id);
    }

    // Private rowMapper method
    private InvoiceItem mapRowToInvoiceItem(ResultSet rs, int rowNum) throws SQLException {
        InvoiceItem item = new InvoiceItem();
        item.setId(rs.getInt("invoice_item_id"));
        item.setInvoiceId(rs.getInt("invoice_id"));
        item.setInventoryId(rs.getInt("inventory_id"));
        item.setQuantity(rs.getInt("quantity"));
        item.setUnitPrice(rs.getBigDecimal("unit_price"));
        return item;
    }
}
