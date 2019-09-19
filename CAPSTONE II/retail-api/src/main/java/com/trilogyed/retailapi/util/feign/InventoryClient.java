package com.trilogyed.retailapi.util.feign;

import com.trilogyed.retailapi.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
    public Inventory getInventory(@PathVariable int id);

    @RequestMapping(value = "/inventory/product/{productId}", method = RequestMethod.GET)
    public Inventory getInventoryByProduct(@PathVariable int productId);

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public List<Inventory> getAllInventoryItems();

}
