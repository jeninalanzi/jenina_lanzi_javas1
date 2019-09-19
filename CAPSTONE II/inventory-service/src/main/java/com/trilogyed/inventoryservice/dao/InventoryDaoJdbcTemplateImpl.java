package com.trilogyed.inventoryservice.dao;

import com.trilogyed.inventoryservice.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InventoryDaoJdbcTemplateImpl implements InventoryDao {

    // Prepared statements
    private static final String INSERT_INVENTORY_SQL = "insert into inventory (product_id, quantity) values (?, ?)";
    private static final String GET_INVENTORY_SQL = "select * from inventory where inventory_id = ?";
    private static final String GET_ALL_INVENTORY_SQL = "select * from inventory";
    private static final String GET_BY_PRODUCT_ID_SQL = "select * from inventory where product_id = ?";
    private static final String UPDATE_INVENTORY_SQL = "update inventory set product_id = ?, quantity = ? where inventory_id = ?";
    private static final String DELETE_INVENTORY_SQL = "delete from inventory where inventory_id = ?";

    // Constructor dependency injection
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Implement all methods
    @Override
    @Transactional
    public Inventory addInventoryItem(Inventory inventory) {
        jdbcTemplate.update(INSERT_INVENTORY_SQL,
                inventory.getProductId(),
                inventory.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        inventory.setId(id);
        return inventory;
    }

    @Override
    public Inventory getInventoryItem(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_INVENTORY_SQL, this::mapRowToInventory, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Inventory getInventoryByProduct(int productId) {
        try {
            return jdbcTemplate.queryForObject(GET_BY_PRODUCT_ID_SQL, this::mapRowToInventory, productId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Inventory> getAllInventory() {
        return jdbcTemplate.query(GET_ALL_INVENTORY_SQL, this::mapRowToInventory);
    }

    @Override
    public void updateInventoryItem(Inventory inventory) {
        jdbcTemplate.update(UPDATE_INVENTORY_SQL,
                inventory.getProductId(),
                inventory.getQuantity(),
                inventory.getId());
    }

    @Override
    public void deleteInventoryItem(int id) {
        jdbcTemplate.update(DELETE_INVENTORY_SQL, id);
    }

    // private rowMapper method
    private Inventory mapRowToInventory(ResultSet rs, int rowNum) throws SQLException {
        Inventory inventory = new Inventory();
        inventory.setId(rs.getInt("inventory_id"));
        inventory.setProductId(rs.getInt("product_id"));
        inventory.setQuantity(rs.getInt("quantity"));
        return inventory;
    }
}
