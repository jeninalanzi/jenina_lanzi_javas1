package com.trilogyed.levelupservice.controller;

import com.trilogyed.levelupservice.dao.LevelUpDao;
import com.trilogyed.levelupservice.model.LevelUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CrossOrigin
public class LevelUpController {

    @Autowired
    LevelUpDao levelUpDao;


    // POST METHOD
    @RequestMapping(value = "/levelup", method = RequestMethod.POST)
    public LevelUp createLevelUpAcct(@RequestBody @Valid LevelUp levelUp) {
        levelUpDao.addLevelUpAcct(levelUp);
        return levelUpDao.getLevelUpAcct(levelUp.getId());
    }


    // GET ALL METHOD
    @RequestMapping(value = "/levelup", method = RequestMethod.GET)
    public List<LevelUp> getAllLevelUpAccts() {
        return levelUpDao.getAllLevelUpAccts();
    }


    // GET BY ID METHOD
    @RequestMapping(value = "/levelup/{id}", method = RequestMethod.GET)
    public LevelUp getLevelUpAcct(@PathVariable int id) {
        return levelUpDao.getLevelUpAcct(id);
    }


    // GET POINTS BY CUSTOMER ID
    @RequestMapping(value = "/levelup/customer/{id}", method = RequestMethod.GET)
    public int getLevelUpPointsByCustomerId(@PathVariable int id) {
        return levelUpDao.getLevelUpPointsByCustomerId(id);
    }


    // UPDATE METHOD
    @RequestMapping(value = "/levelup/{id}", method = RequestMethod.PUT)
    public void updateLevelUpAcct(@RequestBody @Valid LevelUp levelUp, @PathVariable int id) {
        for (LevelUp acct : levelUpDao.getAllLevelUpAccts()) {
            if (acct.getId() == id) {
                acct.setId(id);
                levelUpDao.updateLevelUpAcct(levelUp);
                System.out.println("LevelUp Account updated successfully.");
            }
        }
    }


    // DELETE METHOD
    @RequestMapping(value = "/levelup/{id}", method = RequestMethod.DELETE)
    public void deleteLevelUpAcct(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("LevelUp ID must be greater than 0!");
        }
        levelUpDao.deleteLevelUpAcct(id);
        System.out.println("LevelUp account deleted successfully.");
    }


}
