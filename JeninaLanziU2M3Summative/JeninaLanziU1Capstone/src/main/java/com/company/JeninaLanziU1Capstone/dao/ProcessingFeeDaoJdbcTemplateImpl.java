package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {

    // Prepared statements
    private static final String GET_FEE_BY_PRODUCT_TYPE_SQL =
            "select * from processing_fee where product_type = ?";

    private static final String GET_ALL_FEES =
            "select * from processing_fee";

    // JDBC dependency constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ------- Implement methods (GET ONLY) --------


    @Override
    public ProcessingFee getProcessingFee(String productType) {
        try {
            return jdbcTemplate.queryForObject(GET_FEE_BY_PRODUCT_TYPE_SQL, this::mapRowToProcessingFee, productType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<ProcessingFee> getAllProcessingFees() {
        return jdbcTemplate.query(GET_ALL_FEES, this::mapRowToProcessingFee);
    }

    // rowMapper method
    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee pf = new ProcessingFee();
        pf.setProductType(rs.getString("product_type"));
        pf.setFee(rs.getBigDecimal("fee"));
        return pf;
    }
}
