package com.company.JeninaLanziU1Capstone.controller;

import com.company.JeninaLanziU1Capstone.model.Invoice;
import com.company.JeninaLanziU1Capstone.service.ServiceLayer;
import com.company.JeninaLanziU1Capstone.view.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    // POST METHOD
    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody @Valid InvoiceViewModel ivm) {
        serviceLayer.saveInvoice(ivm);

        return serviceLayer.findInvoice(ivm.getId());
    }

    // GET INVOICE
    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable int id) {
        return serviceLayer.getInvoice(id);
    }

    // GET ALL INVOICES
    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        return serviceLayer.getAllInvoices();
    }

    // UPDATE INVOICE
    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel updateInvoice(@PathVariable int id, @RequestBody InvoiceViewModel viewModel) {
        for (InvoiceViewModel ivm : serviceLayer.getAllInvoices()) {
            if (ivm.getId() == id) {
                viewModel.setId(id);
                serviceLayer.updateInvoice(viewModel);
            }
        }
        return serviceLayer.getInvoice(id);
    }

    // DELETE INVOICE
    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteInvoice(@PathVariable int id) {
        serviceLayer.deleteInvoice(id);
    }

}
