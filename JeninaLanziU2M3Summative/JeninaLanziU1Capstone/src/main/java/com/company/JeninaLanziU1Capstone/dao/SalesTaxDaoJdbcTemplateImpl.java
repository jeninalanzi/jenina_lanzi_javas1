package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxDaoJdbcTemplateImpl implements SalesTaxDao {

    // Prepared statements
    private static final String GET_STATE_TAX_RATE_SQL =
            "select * from sales_tax_rate where state = ?";

    private static final String GET_ALL_TAX_RATES =
            "select * from sales_tax_rate";


    // JDBC dependency
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Implement methods
    @Override
    public SalesTaxRate getTaxRate(String state) {
        try {
            return jdbcTemplate.queryForObject(GET_STATE_TAX_RATE_SQL, this::mapRowToSalesTaxRate, state);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<SalesTaxRate> getAllTaxRates() {
        return jdbcTemplate.query(GET_ALL_TAX_RATES, this::mapRowToSalesTaxRate);
    }

    // rowMapper method
    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate str = new SalesTaxRate();
        str.setState(rs.getString("state"));
        str.setRate(rs.getBigDecimal("rate"));
        return str;
    }
}
