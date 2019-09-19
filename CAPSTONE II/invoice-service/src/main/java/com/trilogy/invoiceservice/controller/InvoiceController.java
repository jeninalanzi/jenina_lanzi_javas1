package com.trilogy.invoiceservice.controller;

import com.trilogy.invoiceservice.dao.InvoiceItemDao;
import com.trilogy.invoiceservice.model.InvoiceItem;
import com.trilogy.invoiceservice.service.ServiceLayer;
import com.trilogy.invoiceservice.view.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CrossOrigin
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;


    // POST METHOD - INVOICE
    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody @Valid InvoiceViewModel ivm) {
        serviceLayer.saveInvoice(ivm);
        return serviceLayer.findInvoice(ivm.getId());
    }

    // POST METHOD - INVOICE ITEM
    @RequestMapping(value = "/invoices/items", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceItem addInvoiceItem(@RequestBody @Valid InvoiceItem invoiceItem) {
        serviceLayer.saveInvoiceItem(invoiceItem);
        return invoiceItem;
    }

    // GET BY ID METHOD
    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public InvoiceViewModel getInvoice(@PathVariable int id) {
        return serviceLayer.findInvoice(id);
    }

    // GET ALL METHOD
    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<InvoiceViewModel> getAllInvoices() {
        return serviceLayer.findAllInvoices();
    }

    // GET BY CUSTOMER METHOD
    @RequestMapping(value = "/invoices/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<InvoiceViewModel> getInvoicesByCustomer(@PathVariable int id) {
        return serviceLayer.findInvoicesByCustomer(id);
    }

    // UPDATE METHOD
    @RequestMapping(value = "/invoices", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateInvoice(@RequestBody @Valid InvoiceViewModel ivm) {
        serviceLayer.updateInvoice(ivm);
        System.out.println("ivm: " + ivm);
        System.out.println("Invoice updated successfully;");
    }

    // DELETE METHOD
    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteInvoice(@PathVariable int id) {
        serviceLayer.removeInvoice(id);
    }

    // GET ITEMS/PRODUCTS BY CUSTOMER ID
    @RequestMapping(value = "/products/invoice/{id}", method = RequestMethod.GET)
    public List<InvoiceItem> getProductsByInvoiceId(@PathVariable int invoiceId) {
        return serviceLayer.getInvoiceItemByInvoice(invoiceId);
    }

    // POST METHOD - SAVE PRODUCT AS AN INVOICE ITEM FOR AN INVOICE
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public InvoiceItem orderProductByInvoice(@RequestBody @Valid InvoiceItem invoiceItem) {
        return serviceLayer.saveInvoiceItem(invoiceItem);
    }

}
