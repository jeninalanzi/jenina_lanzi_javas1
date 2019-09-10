package com.company.JeninaLanziU1Capstone.controller;

import com.company.JeninaLanziU1Capstone.dao.TShirtDao;
import com.company.JeninaLanziU1Capstone.model.Game;
import com.company.JeninaLanziU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class TShirtController {

    @Autowired
    TShirtDao tShirtDao;

    /*
    Perform standard CRUD operations for T-Shirts
    Search for T-Shirts by Color
    Search for T-Shirts by Size
    You must create a separate DAO for T-Shirts
     */

    // POST METHOD
    @RequestMapping(value = "/tshirts", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirt createTShirt(@RequestBody @Valid TShirt tee) {
        tShirtDao.addTshirt(tee);
        return tee;
    }

    // GET ALL METHOD
    @RequestMapping(value = "/tshirts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTees() {
        return tShirtDao.getAllTshirts();
    }

    // GET CONSOLE BY ID
    @RequestMapping(value = "/tshirts/{teeId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public TShirt getTee(@PathVariable int teeId) {
        if (teeId < 1) {
            throw new IllegalArgumentException("TShirt ID must be greater than 0.");
        }
        return tShirtDao.getTshirt(teeId);
    }

    // PUT METHOD
    @RequestMapping(value = "/tshirts/{teeId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirt updateTee(@PathVariable int teeId, @RequestBody @Valid TShirt tee) {
        for (TShirt t : tShirtDao.getAllTshirts()) {
            tee.setId(teeId);
            tShirtDao.updateTshirt(tee);
        }
        return tShirtDao.getTshirt(teeId);
    }

    // DELETE METHOD
    @RequestMapping(value = "/tshirts/{teeId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTee(@PathVariable int teeId) {
        tShirtDao.deleteTshirt(teeId);
    }

    // SEARCH BY COLOR
    @RequestMapping(value = "/tshirts/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> searchTeeByColor(@PathVariable String color) {
        return tShirtDao.searchByColor(color);
    }

    // SEARCH BY SIZE
    @RequestMapping(value = "/tshirts/size/{size}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> searchTeeBySize(@PathVariable String size) {
        return tShirtDao.searchBySize(size);
    }
}
