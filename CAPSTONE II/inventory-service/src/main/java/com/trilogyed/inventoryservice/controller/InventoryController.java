package com.trilogyed.inventoryservice.controller;

import com.trilogyed.inventoryservice.dao.InventoryDao;
import com.trilogyed.inventoryservice.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CrossOrigin
public class InventoryController {

    @Autowired
    InventoryDao inventoryDao;

    // POST METHOD
    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public Inventory addInventory(@RequestBody @Valid Inventory inventory) {
        inventoryDao.addInventoryItem(inventory);
        return inventoryDao.getInventoryItem(inventory.getId());
    }

    // GET BY ID METHOD
    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
    public Inventory getInventory(@PathVariable int id) {
        return inventoryDao.getInventoryItem(id);
    }

    // GET BY PRODUCT ID METHOD
    @RequestMapping(value = "/inventory/product/{productId}", method = RequestMethod.GET)
    public Inventory getInventoryByProduct(@PathVariable int productId) {
        return inventoryDao.getInventoryByProduct(productId);
    }

    // GET ALL METHOD
    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public List<Inventory> getAllInventoryItems() {
        return inventoryDao.getAllInventory();
    }

    // UPDATE METHOD
    @RequestMapping(value = "/inventory", method = RequestMethod.PUT)
    public void updateInventoryItem(@RequestBody @Valid Inventory inventory) {
        for (Inventory item : inventoryDao.getAllInventory()) {
            if (item.getId() == inventory.getId()) {
                inventory.setId(inventory.getId());
                inventoryDao.updateInventoryItem(inventory);
                System.out.println("Inventory item updated successfully");
            }
        }
    }

    // DELETE METHOD
    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.DELETE)
    public void deleteInventory(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Inventory ID must be greater than 0!");
        }
        inventoryDao.deleteInventoryItem(id);
        System.out.println("Inventory item successfully deleted from the database!");

    }

}
