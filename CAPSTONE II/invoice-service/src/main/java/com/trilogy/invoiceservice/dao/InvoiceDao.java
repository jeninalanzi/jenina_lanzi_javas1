package com.trilogy.invoiceservice.dao;

import com.trilogy.invoiceservice.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    List<Invoice> getInvoicesByCustomerId(int id);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int id);
}
