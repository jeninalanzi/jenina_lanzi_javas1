package com.trilogyed.levelupservice.dao;

import com.trilogyed.levelupservice.model.LevelUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LevelUpDaoJdbcTemplateImpl implements LevelUpDao {

    // Prepared Statements
    private static final String INSERT_LEVELUP_SQL = "insert into level_up (customer_id, points, member_date) values (?, ?, ?)";
    private static final String GET_LEVELUP_SQL = "select * from level_up where level_up_id = ?";
    private static final String GET_ALL_LEVELUPS_SQL = "select * from level_up";
    private static final String UPDATE_LEVELUP_SQL = "update level_up set customer_id = ?, points = ?, member_date = ? where level_up_id = ?";
    private static final String DELETE_LEVELUP_SQL = "delete from level_up where level_up_id = ?";
    private static final String GET_LEVELUP_BY_CUSTOMER_ID_SQL = "select * from level_up where customer_id = ?";


    // Constructor dependency injection
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LevelUpDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Implement methods

    @Override
    @Transactional
    public LevelUp addLevelUpAcct(LevelUp levelUp) {
        jdbcTemplate.update(INSERT_LEVELUP_SQL,
                levelUp.getCustomerId(),
                levelUp.getPoints(),
                levelUp.getMemberDate());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        levelUp.setId(id);

        return levelUp;
    }

    @Override
    public LevelUp getLevelUpAcct(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_LEVELUP_SQL, this::mapRowToLevelUp, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<LevelUp> getAllLevelUpAccts() {
        return jdbcTemplate.query(GET_ALL_LEVELUPS_SQL, this::mapRowToLevelUp);
    }

    @Override
    public int getLevelUpPointsByCustomerId(int customerId) {
        LevelUp levelUp = jdbcTemplate.queryForObject(GET_LEVELUP_BY_CUSTOMER_ID_SQL, this::mapRowToLevelUp, customerId);
        return levelUp.getPoints();
    }

    @Override
    public void updateLevelUpAcct(LevelUp levelUp) {
        jdbcTemplate.update(UPDATE_LEVELUP_SQL,
                levelUp.getCustomerId(),
                levelUp.getPoints(),
                levelUp.getMemberDate(),
                levelUp.getId());
    }

    @Override
    public void deleteLevelUpAcct(int id) {
        jdbcTemplate.update(DELETE_LEVELUP_SQL, id);
    }

    // private rowMapper method
    private LevelUp mapRowToLevelUp(ResultSet rs, int rowNum) throws SQLException {
        LevelUp lu = new LevelUp();
        lu.setId(rs.getInt("level_up_id"));
        lu.setCustomerId(rs.getInt("customer_id"));
        lu.setPoints(rs.getInt("points"));
        lu.setMemberDate(rs.getDate("member_date").toLocalDate());
        return lu;
    }

}
