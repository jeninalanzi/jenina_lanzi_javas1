package com.trilogyed.levelupservice.dao;

import com.trilogyed.levelupservice.model.LevelUp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LevelUpDaoTest {

    @Autowired
    LevelUpDao levelUpDao;

    @Before
    public void setUp() throws Exception {
        List<LevelUp> levelUpsList = levelUpDao.getAllLevelUpAccts();
        for (LevelUp l : levelUpsList) {
            levelUpDao.deleteLevelUpAcct(l.getId());
        }
    }

    @Test
    public void addGetDeleteLevelUpAcct() {

        LevelUp levelUp = new LevelUp();
        levelUp.setCustomerId(2);
        levelUp.setPoints(30);
        levelUp.setMemberDate(LocalDate.of(2019, 8, 8));

        levelUp = levelUpDao.addLevelUpAcct(levelUp);

        LevelUp levelUp1 = levelUpDao.getLevelUpAcct(levelUp.getId());

        assertEquals(levelUp1, levelUp);

        levelUpDao.deleteLevelUpAcct(levelUp.getId());

        levelUp1 = levelUpDao.getLevelUpAcct(levelUp.getId());

        assertNull(levelUp1);
    }

    @Test
    public void updateLevelUpAcct() {
        LevelUp levelUp = new LevelUp();
        levelUp.setCustomerId(2);
        levelUp.setPoints(30);
        levelUp.setMemberDate(LocalDate.of(2019, 8, 8));

        levelUp = levelUpDao.addLevelUpAcct(levelUp);

        levelUp.setPoints(100);

        levelUpDao.updateLevelUpAcct(levelUp);

        LevelUp levelUp1 = levelUpDao.getLevelUpAcct(levelUp.getId());

        assertEquals(levelUp1, levelUp);
    }

    @Test
    public void getAllLevelUpAccts() {

        LevelUp levelUp = new LevelUp();
        levelUp.setCustomerId(2);
        levelUp.setPoints(30);
        levelUp.setMemberDate(LocalDate.of(2019, 8, 8));

        LevelUp levelUp1 = new LevelUp();
        levelUp1.setCustomerId(34);
        levelUp1.setPoints(355);
        levelUp1.setMemberDate(LocalDate.of(2019, 1, 5));

        levelUp = levelUpDao.addLevelUpAcct(levelUp);
        levelUp1 = levelUpDao.addLevelUpAcct(levelUp1);

        List<LevelUp> allLevelUpAccts = levelUpDao.getAllLevelUpAccts();

        assertEquals(2, allLevelUpAccts.size());
    }

    @Test
    public void getLevelUpPointsByCustomerId() {

        LevelUp levelUp = new LevelUp();
        levelUp.setCustomerId(2);
        levelUp.setPoints(30);
        levelUp.setMemberDate(LocalDate.of(2019, 8, 8));

        levelUp = levelUpDao.addLevelUpAcct(levelUp);

        int points = levelUpDao.getLevelUpPointsByCustomerId(2);

        assertEquals(30, points);
    }
}
