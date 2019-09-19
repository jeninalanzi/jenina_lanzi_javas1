package com.trilogy.invoiceservice.dao;

import com.trilogy.invoiceservice.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {

    InvoiceItem addInvoiceItem(InvoiceItem item);

    InvoiceItem getInvoiceItem(int id);

    List<InvoiceItem> getAllInvoiceItems();

    List<InvoiceItem> getInvoiceItemsByInvoice(int id);

    void updateInvoiceItem(InvoiceItem item);

    void deleteInvoiceItem(int id);
}
