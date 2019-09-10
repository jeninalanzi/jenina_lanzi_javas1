package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        List<Console> cList = consoleDao.getAllConsoles();
        for (Console c : cList) {
            consoleDao.deleteConsole(c.getId());
        }
    }

    @Test
    public void addGetDeleteConsole() {

        Console console = new Console();
        console.setModel("N64");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("4MB");
        console.setProcessor("1 Core 93.75 MHz");
        console.setPrice(new BigDecimal("75.95"));
        console.setQuantity(100);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getId());

        console1 = consoleDao.getConsole(console.getId());

        assertNull(console1);
    }

    @Test
    public void updateArtist() {

        Console console = new Console();
        console.setModel("N64");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("4MB");
        console.setProcessor("1 Core 93.75 MHz");
        console.setPrice(new BigDecimal("75.95"));
        console.setQuantity(100);

        console = consoleDao.addConsole(console);

        console.setModel("Switch");
        console.setMemoryAmount("4GB");
        console.setProcessor("NVIDIA Custom Tegra");
        console.setPrice(new BigDecimal("297.95"));

        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);
    }

    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setModel("N64");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("4MB");
        console.setProcessor("1 Core 93.75 MHz");
        console.setPrice(new BigDecimal("75.95"));
        console.setQuantity(100);

        Console console1 = new Console();
        console1.setModel("XBox One X");
        console1.setManufacturer("Microsoft");
        console1.setMemoryAmount("12BB");
        console1.setProcessor("2.3 GHz");
        console1.setPrice(new BigDecimal("400.95"));
        console1.setQuantity(20);

        console = consoleDao.addConsole(console);
        console1 = consoleDao.addConsole(console1);

        List<Console> allConsoles = consoleDao.getAllConsoles();

        assertEquals(allConsoles.size(), 2);


    }
}
