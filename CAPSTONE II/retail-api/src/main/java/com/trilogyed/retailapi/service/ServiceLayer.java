package com.trilogyed.retailapi.service;

import com.trilogyed.retailapi.model.Invoice;
import com.trilogyed.retailapi.util.feign.InventoryClient;
import com.trilogyed.retailapi.util.feign.ProductClient;
import com.trilogyed.retailapi.view.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    private final InventoryClient inventoryClient;
    private final InvoiceClient invoiceClient;
    private final ProductClient productClient;

    @Autowired
    public ServiceLayer(InventoryClient inventoryClient, InvoiceClient invoiceClient, ProductClient productClient) {
        this.inventoryClient = inventoryClient;
        this.invoiceClient = invoiceClient;
        this.productClient = productClient;
    }

        public OrderViewModel createOrder(OrderViewModel orderViewModel) {

            // Persist an invoice object first.
            Invoice invoice = new Invoice();
            invoice.setCustomerId(orderViewModel.getCustomerId());
            invoice.setPurchaseDate(orderViewModel.getPurchaseDate());
            invoice = invoiceClient.


            // Then,
    }

}
