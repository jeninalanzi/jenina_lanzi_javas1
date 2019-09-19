package com.trilogyed.inventoryservice.dao;

import com.trilogyed.inventoryservice.model.Inventory;

import java.util.List;

public interface InventoryDao {

    Inventory addInventoryItem(Inventory inventory);

    Inventory getInventoryItem(int id);

    Inventory getInventoryByProduct(int productId);

    List<Inventory> getAllInventory();

    void updateInventoryItem(Inventory inventory);

    void deleteInventoryItem(int id);

}
