package com.trilogyed.levelupservice.dao;

import com.trilogyed.levelupservice.model.LevelUp;

import java.util.List;

public interface LevelUpDao {

    // LevelUp is a Rewards account for users that signup/qualify.
    // Each time it is instantiated, it is per customer.

    LevelUp addLevelUpAcct(LevelUp levelUp);

    LevelUp getLevelUpAcct(int id);

    List<LevelUp> getAllLevelUpAccts();

    void updateLevelUpAcct(LevelUp levelUp);

    void deleteLevelUpAcct(int id);

    // Get LevelUp points by customer id:
    int getLevelUpPointsByCustomerId(int customerId);
}
