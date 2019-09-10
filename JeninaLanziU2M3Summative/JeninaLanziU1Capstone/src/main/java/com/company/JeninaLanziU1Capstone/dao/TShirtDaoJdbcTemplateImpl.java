package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {

    // Prepared Statements

    private static final String INSERT_TEE_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String GET_TEE_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String GET_ALL_TEES =
            "select * from t_shirt";

    private static final String GET_TEE_BY_COLOR =
            "select * from t_shirt where color = ?";

    private static final String GET_TEE_BY_SIZE =
            "select * from t_shirt where size = ?";

    private static final String UPDATE_TEE_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String DELETE_TEE_SQL =
            "delete from t_shirt where t_shirt_id = ?";


    // JDBC dependency constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // --------------------------- Implement all methods ---------------------------------


    @Override
    @Transactional
    public TShirt addTshirt(TShirt tee) {
        jdbcTemplate.update(
                INSERT_TEE_SQL,
                tee.getSize(),
                tee.getColor(),
                tee.getDescription(),
                tee.getPrice(),
                tee.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        tee.setId(id);
        return tee;
    }

    @Override
    public TShirt getTshirt(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_TEE_SQL, this::mapRowToTShirt, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<TShirt> getAllTshirts() {
        return jdbcTemplate.query(GET_ALL_TEES, this::mapRowToTShirt);
    }

    @Override
    public List<TShirt> searchByColor(String color) {
        return jdbcTemplate.query(GET_TEE_BY_COLOR, this::mapRowToTShirt, color);
    }

    @Override
    public List<TShirt> searchBySize(String size) {
        return jdbcTemplate.query(GET_TEE_BY_SIZE, this::mapRowToTShirt, size);
    }

    @Override
    public void updateTshirt(TShirt tee) {
        jdbcTemplate.update(
                UPDATE_TEE_SQL,
                tee.getSize(),
                tee.getColor(),
                tee.getDescription(),
                tee.getPrice(),
                tee.getQuantity(),
                tee.getId());
    }

    @Override
    public void deleteTshirt(int id) {
        jdbcTemplate.update(DELETE_TEE_SQL, id);
    }

    // rowMapper method
    private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt tee = new TShirt();
        tee.setId(rs.getInt("t_shirt_id"));
        tee.setSize(rs.getString("size"));
        tee.setColor(rs.getString("color"));
        tee.setDescription(rs.getString("description"));
        tee.setPrice(rs.getBigDecimal("price"));
        tee.setQuantity(rs.getInt("quantity"));
        return tee;
    }

}
