package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    /*
    Perform standard CRUD operations for Consoles
    Search for Consoles by Manufacturer
     */

    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    List<Console> searchByManufacturer(String manufacturer);

    void updateConsole(Console console);

    void deleteConsole(int id);

}
