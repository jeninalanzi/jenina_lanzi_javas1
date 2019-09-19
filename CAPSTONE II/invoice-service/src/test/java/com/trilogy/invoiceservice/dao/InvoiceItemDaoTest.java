package com.trilogy.invoiceservice.dao;

import com.trilogy.invoiceservice.model.Invoice;
import com.trilogy.invoiceservice.model.InvoiceItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceItemDaoTest {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    InvoiceItemDao invoiceItemDao;

    @Before
    public void setUp() throws Exception {
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
        for (InvoiceItem i : invoiceItemList) {
            invoiceItemDao.deleteInvoiceItem(i.getId());
        }

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        for (Invoice i : invoiceList) {
            invoiceDao.deleteInvoice(i.getId());
        }
    }

    @Test
    public void addGetDeleteInvoiceItem() {

        // Add invoice first.
        Invoice invoice = new Invoice();
        invoice.setCustomerId(1);
        invoice.setPurchaseDate(LocalDate.of(2018, 7, 18));

        invoice = invoiceDao.addInvoice(invoice);

        // Add invoice item next.
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setInventoryId(11);
        invoiceItem.setQuantity(5);
        invoiceItem.setUnitPrice(new BigDecimal("12.98"));

        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem2 = invoiceItemDao.getInvoiceItem(invoiceItem.getId());

        assertEquals(invoiceItem2, invoiceItem);

        invoiceItemDao.deleteInvoiceItem(invoiceItem.getId());

        invoiceItem2 = invoiceItemDao.getInvoiceItem(invoiceItem.getId());

        assertNull(invoiceItem2);
    }

    @Test
    public void updateInvoiceItem() {

        // Add invoice first.
        Invoice invoice = new Invoice();
        invoice.setCustomerId(1);
        invoice.setPurchaseDate(LocalDate.of(2018, 7, 18));

        invoice = invoiceDao.addInvoice(invoice);

        // Add invoice item next.
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setInventoryId(11);
        invoiceItem.setQuantity(5);
        invoiceItem.setUnitPrice(new BigDecimal("12.98"));

        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        invoiceItem.setUnitPrice(new BigDecimal("13.77"));

        invoiceItemDao.updateInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getId());

        assertEquals(invoiceItem1, invoiceItem);
    }

    @Test
    public void getAllInvoiceItems() {

        // Add invoice first.
        Invoice invoice = new Invoice();
        invoice.setCustomerId(1);
        invoice.setPurchaseDate(LocalDate.of(2018, 7, 18));

        invoice = invoiceDao.addInvoice(invoice);

        // Add invoice items next.
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setInventoryId(11);
        invoiceItem.setQuantity(5);
        invoiceItem.setUnitPrice(new BigDecimal("12.98"));

        InvoiceItem invoiceItem2 = new InvoiceItem();
        invoiceItem2.setInvoiceId(invoice.getId());
        invoiceItem2.setInventoryId(20);
        invoiceItem2.setQuantity(1);
        invoiceItem2.setUnitPrice(new BigDecimal("50.98"));

        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        invoiceItem2 = invoiceItemDao.addInvoiceItem(invoiceItem2);

        List<InvoiceItem> allInvoiceItems = invoiceItemDao.getAllInvoiceItems();

        assertEquals(2, allInvoiceItems.size());
    }

    @Test
    public void getInvoiceItemsByInvoice() {

        // Add invoice(s) first.
        Invoice invoice = new Invoice();
        invoice.setCustomerId(1);
        invoice.setPurchaseDate(LocalDate.of(2018, 7, 18));

        Invoice invoice2 = new Invoice();
        invoice2.setCustomerId(3);
        invoice2.setPurchaseDate(LocalDate.of(2019, 3, 22));

        invoice = invoiceDao.addInvoice(invoice);
        invoice2 = invoiceDao.addInvoice(invoice2);

        // Add invoice items next.
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setInventoryId(11);
        invoiceItem.setQuantity(5);
        invoiceItem.setUnitPrice(new BigDecimal("12.98"));

        InvoiceItem invoiceItem2 = new InvoiceItem();
        invoiceItem2.setInvoiceId(invoice.getId());
        invoiceItem2.setInventoryId(20);
        invoiceItem2.setQuantity(1);
        invoiceItem2.setUnitPrice(new BigDecimal("50.98"));

        InvoiceItem invoiceItem3 = new InvoiceItem();
        invoiceItem3.setInvoiceId(invoice2.getId());
        invoiceItem3.setInventoryId(35);
        invoiceItem3.setQuantity(2);
        invoiceItem3.setUnitPrice(new BigDecimal("7.50"));

        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        invoiceItem2 = invoiceItemDao.addInvoiceItem(invoiceItem2);
        invoiceItem3 = invoiceItemDao.addInvoiceItem(invoiceItem3);

        assertEquals(1, invoiceItemDao.getInvoiceItemsByInvoice(invoice2.getId()).size());
        assertEquals(2, invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId()).size());

    }
}
