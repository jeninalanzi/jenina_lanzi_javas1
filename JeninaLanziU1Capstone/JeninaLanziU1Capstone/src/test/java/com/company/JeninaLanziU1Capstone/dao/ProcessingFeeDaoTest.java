package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.ProcessingFee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {

    @Autowired
    ProcessingFeeDao pfDao;

    @Test
    public void getGameFee() {
        ProcessingFee gameFee = pfDao.getProcessingFee("Games");
        assertEquals(gameFee.getFee(), new BigDecimal("1.49"));
    }

    @Test
    public void getConsoleFee() {
        ProcessingFee consoleFee = pfDao.getProcessingFee("Consoles");
        assertEquals(consoleFee.getFee(), new BigDecimal("14.99"));
    }

    @Test
    public void getTShirtFee() {
        ProcessingFee teeFee = pfDao.getProcessingFee("T-Shirts");
        assertEquals(teeFee.getFee(), new BigDecimal("1.98"));
    }

    @Test
    public void getAllFees() {
        List<ProcessingFee> allFeesList = pfDao.getAllProcessingFees();
        assertEquals(allFeesList.size(), 3);
    }
}
