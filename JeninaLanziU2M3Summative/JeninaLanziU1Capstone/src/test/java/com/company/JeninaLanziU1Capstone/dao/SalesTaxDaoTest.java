package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.SalesTaxRate;
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
public class SalesTaxDaoTest {

    @Autowired
    SalesTaxDao salesTaxDao;

    @Test
    public void getTaxRate() {
        SalesTaxRate illinoisRate = salesTaxDao.getTaxRate("IL");
        assertEquals(illinoisRate.getRate(), new BigDecimal(".05"));

        SalesTaxRate texasRate = salesTaxDao.getTaxRate("TX");
        assertEquals(texasRate.getRate(), new BigDecimal(".03"));

        SalesTaxRate floridaRate = salesTaxDao.getTaxRate("FL");
        assertEquals(floridaRate.getRate(), new BigDecimal(".06"));
    }

    @Test
    public void getAllTaxRates() {
        List<SalesTaxRate> allRates = salesTaxDao.getAllTaxRates();
        assertEquals(allRates.size(), 50);
    }
}
