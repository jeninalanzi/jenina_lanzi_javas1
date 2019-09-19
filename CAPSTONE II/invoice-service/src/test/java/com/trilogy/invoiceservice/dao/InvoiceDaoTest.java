package com.trilogy.invoiceservice.dao;

import com.trilogy.invoiceservice.model.Invoice;
import com.trilogy.invoiceservice.model.InvoiceItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    InvoiceItemDao itemDao;

    @Before
    public void setUp() throws Exception {
        List<InvoiceItem> itemsList = itemDao.getAllInvoiceItems();
        for (InvoiceItem i : itemsList) {
            itemDao.deleteInvoiceItem(i.getId());
        }

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        for (Invoice i : invoiceList) {
            invoiceDao.deleteInvoice(i.getId());
        }
    }

    @Test
    public void addGetDeleteInvoice() {

        Invoice invoice = new Invoice();
        invoice.setCustomerId(34);
        invoice.setPurchaseDate(LocalDate.of(2019, 5, 15));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getId());

        assertEquals(invoice1, invoice);

        invoiceDao.deleteInvoice(invoice.getId());

        invoice1 = invoiceDao.getInvoice(invoice.getId());

        assertNull(invoice1);
    }

    @Test
    public void getInvoiceByCustomerId() {

        Invoice invoice = new Invoice();
        invoice.setCustomerId(34);
        invoice.setPurchaseDate(LocalDate.of(2019, 5, 15));

        Invoice invoice1 = new Invoice();
        invoice1.setCustomerId(34);
        invoice1.setPurchaseDate(LocalDate.of(2019, 9, 18));

        Invoice invoice2 = new Invoice();
        invoice2.setCustomerId(6);
        invoice2.setPurchaseDate(LocalDate.of(2017, 10, 5));

        invoice = invoiceDao.addInvoice(invoice);
        invoice1 = invoiceDao.addInvoice(invoice1);
        invoice2 = invoiceDao.addInvoice(invoice2);

        List<Invoice> invoicesByCustomer34 = invoiceDao.getInvoicesByCustomerId(34);

        assertEquals(2, invoicesByCustomer34.size());
    }

    @Test
    public void updateInvoice() {

        Invoice invoice = new Invoice();
        invoice.setCustomerId(34);
        invoice.setPurchaseDate(LocalDate.of(2019, 5, 15));

        invoice = invoiceDao.addInvoice(invoice);

        invoice.setPurchaseDate(LocalDate.of(2019, 10, 30));

        invoiceDao.updateInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getId());

        assertEquals(invoice1, invoice);
    }

    @Test
    public void getAllInvoices() {

        Invoice invoice = new Invoice();
        invoice.setCustomerId(34);
        invoice.setPurchaseDate(LocalDate.of(2019, 5, 15));

        Invoice invoice1 = new Invoice();
        invoice1.setCustomerId(34);
        invoice1.setPurchaseDate(LocalDate.of(2019, 9, 18));

        Invoice invoice2 = new Invoice();
        invoice2.setCustomerId(6);
        invoice2.setPurchaseDate(LocalDate.of(2017, 10, 5));

        invoice = invoiceDao.addInvoice(invoice);
        invoice1 = invoiceDao.addInvoice(invoice1);
        invoice2 = invoiceDao.addInvoice(invoice2);

        List<Invoice> allInvoices = invoiceDao.getAllInvoices();

        assertEquals(3, allInvoices.size());
    }

    @Test
    public void findInvoicesByCustomerId() {

        Invoice invoice = new Invoice();
        invoice.setCustomerId(34);
        invoice.setPurchaseDate(LocalDate.of(2019, 5, 15));

        Invoice invoice1 = new Invoice();
        invoice1.setCustomerId(34);
        invoice1.setPurchaseDate(LocalDate.of(2019, 9, 18));

        Invoice invoice2 = new Invoice();
        invoice2.setCustomerId(6);
        invoice2.setPurchaseDate(LocalDate.of(2017, 10, 5));

        invoice = invoiceDao.addInvoice(invoice);
        invoice1 = invoiceDao.addInvoice(invoice1);
        invoice2 = invoiceDao.addInvoice(invoice2);

        List<Invoice> invoicesByCustomer = invoiceDao.getInvoicesByCustomerId(34);
        System.out.println(invoicesByCustomer);
        assertEquals(2, invoicesByCustomer.size());



    }
}
