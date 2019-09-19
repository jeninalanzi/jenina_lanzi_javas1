package com.trilogy.invoiceservice.service;

import com.trilogy.invoiceservice.dao.InvoiceDao;
import com.trilogy.invoiceservice.dao.InvoiceItemDao;
import com.trilogy.invoiceservice.model.Invoice;
import com.trilogy.invoiceservice.model.InvoiceItem;
import com.trilogy.invoiceservice.view.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;

    @Autowired
    public ServiceLayer(InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao) {
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
    }

    // --------------------------------------------------------------------------------
    // Service Layer Methods

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel) {

        // Persist Invoice first.
        Invoice invoice = new Invoice();
        invoice.setCustomerId(viewModel.getCustomerId());
        invoice.setPurchaseDate(viewModel.getPurchaseDate());
        invoice = invoiceDao.addInvoice(invoice);

        // Set new ID of Invoice to be the viewModel's new ID.
        viewModel.setId(invoice.getId());

        // Create a List of InvoiceItems, from the viewModel.
        // Then, persist those items in the InvoiceItemDao.
        List<InvoiceItem> invoiceItems = viewModel.getInvoiceItemsList();
        invoiceItems.stream()
                .forEach(invoiceItem -> {
                    invoiceItem.setInvoiceId(viewModel.getId());
                    invoiceItemDao.addInvoiceItem(invoiceItem);
                });

        // Obtain persisted InvoiceItems from the DAO.
        invoiceItems = invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId());

        // Set the list of InvoiceItems into the viewModel.
        viewModel.setInvoiceItemsList(invoiceItems);

        return viewModel;
    }

    public InvoiceViewModel findInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);

        if (invoice == null) {
            return null;
        } else {
            return buildInvoiceViewModel(invoice);
        }
    }

    @Transactional
    public void updateInvoice(InvoiceViewModel viewModel) {

        // Persist & update Invoice first.
        Invoice invoice = new Invoice();
        invoice.setId(viewModel.getId());
        invoice.setCustomerId(viewModel.getCustomerId());
        invoice.setPurchaseDate(viewModel.getPurchaseDate());
        invoiceDao.updateInvoice(invoice);

        List<InvoiceItem> invoiceItems = invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId());
        invoiceItems.stream()
                .forEach(invoiceItem -> {
                    invoiceItem.setInvoiceId(viewModel.getId());
                    invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
                });
    }

    public List<InvoiceViewModel> findInvoicesByCustomer(int customerId) {
        List<Invoice> invoices = invoiceDao.getInvoicesByCustomerId(customerId);
        List<InvoiceViewModel> invoiceViewModels = new ArrayList<>();

        for (Invoice invoice : invoices) {
            invoiceViewModels.add(buildInvoiceViewModel(invoice));
        }
        return invoiceViewModels;
    }

    public List<InvoiceViewModel> findAllInvoices() {
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        List<InvoiceViewModel> invoiceViewModels = new ArrayList<>();

        for (Invoice invoice : invoices) {
            invoiceViewModels.add(buildInvoiceViewModel(invoice));
        }
        return invoiceViewModels;
    }

    @Transactional
    public void removeInvoice(int id) {
        List<InvoiceItem> invoiceItems = invoiceItemDao.getInvoiceItemsByInvoice(id);

        invoiceItems.stream()
                .forEach(i -> invoiceItemDao.deleteInvoiceItem(i.getId()));

        invoiceDao.deleteInvoice(id);
    }

    // --------------------------------------------------------------------------------
    // Helper methods for serviceLayer.

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        // Get invoice items associated with the invoice.
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId());

        // Assemble the InvoiceViewModel
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getId());
        ivm.setCustomerId(invoice.getCustomerId());
        ivm.setPurchaseDate(invoice.getPurchaseDate());
        ivm.setInvoiceItemsList(invoiceItemList);

        // Return the InvoiceViewModel
        return ivm;
    }

    // --------------------------------------------------------------------------------
    // Some methods for handling Invoice Items through the ServiceLayer as well.

    @Transactional
    public InvoiceItem saveInvoiceItem(InvoiceItem item) {
        return invoiceItemDao.addInvoiceItem(item);
    }

    public List<InvoiceItem> getInvoiceItemByInvoice(int id) {
        return invoiceItemDao.getInvoiceItemsByInvoice(id);
    }

}
