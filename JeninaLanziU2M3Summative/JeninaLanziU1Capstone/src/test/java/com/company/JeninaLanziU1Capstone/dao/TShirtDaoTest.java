package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoTest {

    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {
        List<TShirt> tList = tShirtDao.getAllTshirts();
        for (TShirt t : tList) {
            tShirtDao.deleteTshirt(t.getId());
        }
    }

    @Test
    public void addGetDeleteTShirt() {

        TShirt tee = new TShirt();
        tee.setSize("M");
        tee.setColor("Blue");
        tee.setDescription("Mario Brothers Party Tee");
        tee.setPrice(new BigDecimal("17.99"));
        tee.setQuantity(5);

        tee = tShirtDao.addTshirt(tee);

        TShirt tee1 = tShirtDao.getTshirt(tee.getId());

        assertEquals(tee1, tee);
    }

    @Test
    public void updateTShirt() {

        TShirt tee = new TShirt();
        tee.setSize("M");
        tee.setColor("Blue");
        tee.setDescription("Mario Brothers Party Tee");
        tee.setPrice(new BigDecimal("17.99"));
        tee.setQuantity(5);
        tee = tShirtDao.addTshirt(tee);

        tee.setSize("S");
        tee.setColor("Red");

        tShirtDao.updateTshirt(tee);

        TShirt tee1 = tShirtDao.getTshirt(tee.getId());
        assertEquals(tee1, tee);
    }

    @Test
    public void getAllTShirts() {

        TShirt tee = new TShirt();
        tee.setSize("M");
        tee.setColor("Blue");
        tee.setDescription("Mario Brothers Party Tee");
        tee.setPrice(new BigDecimal("17.99"));
        tee.setQuantity(5);

        TShirt tee1 = new TShirt();
        tee1.setSize("S");
        tee1.setColor("Red");
        tee1.setDescription("Mario Brothers Party Tee");
        tee1.setPrice(new BigDecimal("17.99"));
        tee1.setQuantity(7);

        tee = tShirtDao.addTshirt(tee);
        tee1 = tShirtDao.addTshirt(tee1);

        List<TShirt> allTees = tShirtDao.getAllTshirts();
        assertEquals(allTees.size(), 2);

    }

    @Test
    public void getTShirtsBySearch() {

        TShirt tee = new TShirt();
        tee.setSize("L");
        tee.setColor("Blue");
        tee.setDescription("Mario Brothers Party Tee");
        tee.setPrice(new BigDecimal("17.99"));
        tee.setQuantity(5);

        TShirt tee1 = new TShirt();
        tee1.setSize("S");
        tee1.setColor("Red");
        tee1.setDescription("Mario Brothers Party Tee");
        tee1.setPrice(new BigDecimal("17.99"));
        tee1.setQuantity(7);

        TShirt tee2 = new TShirt();
        tee2.setSize("M");
        tee2.setColor("Green");
        tee2.setDescription("Minecraft Creeper Tee");
        tee2.setPrice(new BigDecimal("20.99"));
        tee2.setQuantity(3);

        TShirt tee3 = new TShirt();
        tee3.setSize("S");
        tee3.setColor("Blue");
        tee3.setDescription("Bomberman 64 Antique/Collector's Tee");
        tee3.setPrice(new BigDecimal("28.99"));
        tee3.setQuantity(4);

        tee = tShirtDao.addTshirt(tee);
        tee1 = tShirtDao.addTshirt(tee1);
        tee2 = tShirtDao.addTshirt(tee2);
        tee3 = tShirtDao.addTshirt(tee3);

        List<TShirt> allTeesBySizeS = tShirtDao.searchBySize("S");
        assertEquals(allTeesBySizeS.size(), 2);

        List<TShirt> allTeesBySizeM = tShirtDao.searchBySize("M");
        assertEquals(allTeesBySizeM.size(), 1);

        List<TShirt> allTeesBySizeL = tShirtDao.searchBySize("L");
        assertEquals(allTeesBySizeL.size(), 1);

        List<TShirt> allTeesBySizeXS = tShirtDao.searchBySize("XS");
        assertEquals(allTeesBySizeXS.size(), 0);

        List<TShirt> allTeesByColor = tShirtDao.searchByColor("Blue");
        assertEquals(allTeesByColor.size(), 2);

        allTeesByColor = tShirtDao.searchByColor("White");
        assertEquals(allTeesByColor.size(), 0);
    }
}
