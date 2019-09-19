package com.trilogy.invoiceservice.service;

import com.trilogy.invoiceservice.dao.InvoiceDao;
import com.trilogy.invoiceservice.dao.InvoiceDaoJdbcTemplateImpl;
import com.trilogy.invoiceservice.dao.InvoiceItemDao;
import com.trilogy.invoiceservice.dao.InvoiceItemDaoJdbcTemplateImpl;
import com.trilogy.invoiceservice.model.Invoice;
import com.trilogy.invoiceservice.model.InvoiceItem;
import com.trilogy.invoiceservice.view.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer mockService;
    InvoiceDao mockInvoiceDao;
    InvoiceItemDao mockInvoiceItemDao;

    @Before
    public void setUp() throws Exception {
        setUpInvoiceDaoMock();
        setUpInvoiceItemDaoMock();
        mockService = new ServiceLayer(mockInvoiceDao, mockInvoiceItemDao);
    }

    @Test
    public void saveFindInvoice() {

        // Set up InvoiceViewModel values.
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(1);
        invoiceViewModel.setCustomerId(21);
        invoiceViewModel.setPurchaseDate(LocalDate.of(2019, 5,5));

        // Set up InvoiceItem values.
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setInventoryId(10);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitPrice(new BigDecimal("3.99"));
        invoiceItem = mockService.saveInvoiceItem(invoiceItem);

        // Create a list of InvoiceItems and add InvoiceItem above to that list.
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItem);

        // Assign the list above to viewModel's invoice items list.
        invoiceViewModel.setInvoiceItemsList(invoiceItems);

        InvoiceViewModel fromService = mockService.findInvoice(invoiceViewModel.getId());
        assertEquals(invoiceViewModel, fromService);
    }

    @Test
    public void updateInvoiceViewModel() {

        // Set up InvoiceViewModel values.
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(1);
        invoiceViewModel.setCustomerId(21);
        invoiceViewModel.setPurchaseDate(LocalDate.of(2019, 5,5));

        // Pass those values into update method
        mockService.updateInvoice(invoiceViewModel);

        // Set up InvoiceItem values.
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setInventoryId(10);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitPrice(new BigDecimal("3.99"));
        invoiceItem = mockService.saveInvoiceItem(invoiceItem);

        // Create a list of InvoiceItems and add InvoiceItem above to that list.
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItem);

        // Assign the list above to viewModel's invoice items list.
        invoiceViewModel.setInvoiceItemsList(invoiceItems);

        InvoiceViewModel fromService = mockService.findInvoice(invoiceViewModel.getId());
        assertEquals(invoiceViewModel, fromService);
    }

    @Test
    public void findInvoicesByCustomerId() {

        // Always persist Objects first.
        // Set up InvoiceViewModel values.
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(1);
        invoiceViewModel.setCustomerId(21);
        invoiceViewModel.setPurchaseDate(LocalDate.of(2019, 5,5));

        // Set up InvoiceItem values.
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setInventoryId(10);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitPrice(new BigDecimal("3.99"));
        invoiceItem = mockService.saveInvoiceItem(invoiceItem);

        // Create a list of InvoiceItems and add InvoiceItem above to that list.
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItem);

        // Assign the list above to viewModel's invoice items list.
        invoiceViewModel.setInvoiceItemsList(invoiceItems);

    }

    // Helper methods
    private void setUpInvoiceDaoMock() {
        // Mock an invoice object to test.
        mockInvoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        // Create a new invoice object.
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setCustomerId(21);
        invoice.setPurchaseDate(LocalDate.of(2019, 5,5));

        // Create a new invoice object - all values should be the same as the one in db.
        // No ID provided so the SQL table auto-generates it for the object.
        Invoice invoice2 = new Invoice();
        invoice2.setCustomerId(21);
        invoice2.setPurchaseDate(LocalDate.of(2019,5,5));

        List<Invoice> iList = new ArrayList<>();
        iList.add(invoice);

        // Mock handle: mockInvoiceDao to all methods we want to test
        doReturn(invoice).when(mockInvoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(mockInvoiceDao).getInvoice(1);
        doReturn(iList).when(mockInvoiceDao).getAllInvoices();
    }


    private void setUpInvoiceItemDaoMock() {
        mockInvoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(1);
        invoiceItem.setInvoiceId(1);
        invoiceItem.setInventoryId(10);
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitPrice(new BigDecimal("3.99"));

        InvoiceItem invoiceItem2 = new InvoiceItem();
        invoiceItem2.setInvoiceId(1);
        invoiceItem2.setInventoryId(10);
        invoiceItem2.setQuantity(2);
        invoiceItem2.setUnitPrice(new BigDecimal("3.99"));

        List<InvoiceItem> iList = new ArrayList<>();
        iList.add(invoiceItem);

        doReturn(invoiceItem).when(mockInvoiceItemDao).addInvoiceItem(invoiceItem2);
        doReturn(invoiceItem).when(mockInvoiceItemDao).getInvoiceItem(1);
        doReturn(iList).when(mockInvoiceItemDao).getAllInvoiceItems();
        doReturn(iList).when(mockInvoiceItemDao).getInvoiceItemsByInvoice(1);
    }
}
