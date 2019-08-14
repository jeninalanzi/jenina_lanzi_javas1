package com.company.JeninaLanziU1Capstone.controller;

import com.company.JeninaLanziU1Capstone.dao.ConsoleDao;
import com.company.JeninaLanziU1Capstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ConsoleController {

    @Autowired
    ConsoleDao consoleDao;

    /*
    Perform standard CRUD operations for Consoles
    Search for Consoles by Manufacturer
    You must create a separate DAO for Consoles
     */

    // POST METHOD
    @RequestMapping(value = "/consoles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {
        consoleDao.addConsole(console);
        return console;
    }

    // GET ALL METHOD
    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    // GET BY ID
    @RequestMapping(value = "/consoles/{consoleId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsole(@PathVariable int consoleId) {
        if (consoleId < 1) {
            throw new IllegalArgumentException("Console ID needs to be greater than 0.");
        }
        return consoleDao.getConsole(consoleId);
    }

    // UPDATE METHOD
    @RequestMapping(value = "/consoles/{consoleId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console updateConsole(@PathVariable int consoleId, @RequestBody @Valid Console console) {
        for (Console c : consoleDao.getAllConsoles()) {
            console.setId(consoleId);
            consoleDao.updateConsole(console);
        }
        return consoleDao.getConsole(consoleId);
    }

    // DELETE METHOD
    @RequestMapping(value = "/consoles/{consoleId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteConsole(@PathVariable int consoleId) {
        consoleDao.deleteConsole(consoleId);
    }

    // GET BY MANUFACTURER
    @RequestMapping(value = "/consoles/manufacturer/{mfr}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String mfr) {
        return consoleDao.searchByManufacturer(mfr);
    }

}
