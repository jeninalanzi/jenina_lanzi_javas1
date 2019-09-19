package com.trilogyed.inventoryservice.dao;

import com.trilogyed.inventoryservice.model.Inventory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InventoryDaoTest {

    @Autowired
    InventoryDao inventoryDao;

    @Before
    public void setUp() throws Exception {
        List<Inventory> allInventory = inventoryDao.getAllInventory();
        for (Inventory i : allInventory) {
            inventoryDao.deleteInventoryItem(i.getId());
        }
    }

    @Test
    public void addGetDeleteInventoryItem() {

        Inventory inventoryItem = new Inventory();
        inventoryItem.setProductId(10);
        inventoryItem.setQuantity(36);

        inventoryItem = inventoryDao.addInventoryItem(inventoryItem);

        Inventory inventoryItem1 = inventoryDao.getInventoryItem(inventoryItem.getId());

        assertEquals(inventoryItem1, inventoryItem);

        inventoryDao.deleteInventoryItem(inventoryItem.getId());

        inventoryItem1 = inventoryDao.getInventoryItem(inventoryItem.getId());

        assertNull(inventoryItem1);
    }

    @Test
    public void updateInventoryItem() {
        Inventory inventoryItem = new Inventory();
        inventoryItem.setProductId(10);
        inventoryItem.setQuantity(36);

        inventoryItem = inventoryDao.addInventoryItem(inventoryItem);

        inventoryItem.setQuantity(100);

        inventoryDao.updateInventoryItem(inventoryItem);

        Inventory item1 = inventoryDao.getInventoryItem(inventoryItem.getId());


    }

    @Test
    public void getAllInventoryItemsAndGetByProduct() {

        Inventory inventoryItem = new Inventory();
        inventoryItem.setProductId(10);
        inventoryItem.setQuantity(36);

        Inventory inventoryItem1 = new Inventory();
        inventoryItem1.setProductId(11);
        inventoryItem1.setQuantity(2);

        inventoryItem = inventoryDao.addInventoryItem(inventoryItem);
        inventoryItem1 = inventoryDao.addInventoryItem(inventoryItem1);

        List<Inventory> allInventoryItems = inventoryDao.getAllInventory();

        assertEquals(2, allInventoryItems.size());

        Inventory testItem = inventoryDao.getInventoryByProduct(11);

        assertEquals(inventoryItem1, testItem);


    }
}
