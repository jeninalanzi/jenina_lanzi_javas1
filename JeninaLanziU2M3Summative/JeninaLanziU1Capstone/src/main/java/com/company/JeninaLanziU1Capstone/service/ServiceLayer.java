package com.company.JeninaLanziU1Capstone.service;

import com.company.JeninaLanziU1Capstone.dao.*;
import com.company.JeninaLanziU1Capstone.model.*;
import com.company.JeninaLanziU1Capstone.view.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxDao salesTaxDao;
    private TShirtDao tShirtDao;
    private InvoiceDao invoiceDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxDao salesTaxDao, TShirtDao tShirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxDao = salesTaxDao;
        this.tShirtDao = tShirtDao;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel) {

        // Persist Invoice object first.
        Invoice i = new Invoice();
        i.setName(viewModel.getName());
        i.setStreet(viewModel.getStreet());
        i.setCity(viewModel.getCity());
        i.setState(viewModel.getState());
        i.setZipcode(viewModel.getZipcode());
        i.setItemType(viewModel.getItemType());
        i.setItemId(viewModel.getItemId());
        i.setQuantity(viewModel.getQuantity());


        // Business logic to determine the rest of the invoice.

        Console consoleStock = consoleDao.getConsole(viewModel.getItemId());
        Game gameStock = gameDao.getGame(viewModel.getItemId());
        TShirt tShirtStock = tShirtDao.getTshirt(viewModel.getItemId());

        int quantityOrdered = viewModel.getQuantity();

        // Calculate and obtain unitPrice.
        if (viewModel.getItemType().equals("Consoles")) {
            i.setUnitPrice(consoleDao.getConsole(viewModel.getItemId()).getPrice());

            consoleStock.setQuantity(consoleStock.getQuantity() - quantityOrdered);
            consoleDao.updateConsole(consoleStock);

        } else if (viewModel.getItemType().equals("Games")) {
            i.setUnitPrice(gameDao.getGame(viewModel.getItemId()).getPrice());

            gameStock.setQuantity(gameStock.getQuantity() - quantityOrdered);
            gameDao.updateGame(gameStock);

        } else if (viewModel.getItemType().equals("T-Shirts")) {
            i.setUnitPrice(tShirtDao.getTshirt(viewModel.getItemId()).getPrice());

            tShirtStock.setQuantity(tShirtStock.getQuantity() - quantityOrdered);
            tShirtDao.updateTshirt(tShirtStock);

        }

        // Calculate & obtain subtotal
        i.setSubtotal(i.getUnitPrice().multiply(BigDecimal.valueOf(viewModel.getQuantity())));

        BigDecimal subtotal = i.getSubtotal();
        BigDecimal stateTaxRate = salesTaxDao.getTaxRate(viewModel.getState()).getRate();
        BigDecimal taxAmount = subtotal.multiply(stateTaxRate).setScale(2, RoundingMode.HALF_UP);
        System.out.println("taxAmount: " + taxAmount);

        // Calculate and obtain tax
        i.setTax(taxAmount);

        // Calculate and obtain processingFee.
        // If quantity of order exceeds 10, apply + $15.49 to order
        if (viewModel.getQuantity() > 10) {
            i.setProcessingFee(processingFeeDao.getProcessingFee(viewModel.getItemType()).getFee().add(new BigDecimal("15.49")));
        } else {
            i.setProcessingFee(processingFeeDao.getProcessingFee(viewModel.getItemType()).getFee());
        }

        // Calculate and obtain order total.
        i.setTotal(subtotal.add(taxAmount).add(i.getProcessingFee()));

        // Save invoice into invoiceDao and obtain id.
        i = invoiceDao.addInvoice(i);
        viewModel.setId(i.getInvoiceId());

        System.out.println(i);
        return viewModel;
    }

    public InvoiceViewModel getInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);

        return buildInvoiceViewModel(invoice);
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        // Get associated invoice
        Invoice i = invoiceDao.getInvoice(invoice.getInvoiceId());

        // Get the associated sales tax rate
        SalesTaxRate salesTax = salesTaxDao.getTaxRate(invoice.getState());

        // Get the associated processing fee
        ProcessingFee processingFee = processingFeeDao.getProcessingFee(invoice.getItemType());

        // Assemble the InvoiceViewModel
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(i.getInvoiceId());
        ivm.setName(i.getName());
        ivm.setStreet(i.getStreet());
        ivm.setCity(i.getCity());
        ivm.setState(i.getState());
        ivm.setZipcode(i.getZipcode());
        ivm.setItemType(i.getItemType());
        ivm.setItemId(i.getItemId());
        ivm.setUnitPrice(i.getUnitPrice());
        ivm.setQuantity(i.getQuantity());
        ivm.setSubtotal(i.getSubtotal());
        ivm.setTax(salesTax);
        ivm.setTaxAmount(salesTax.getRate().multiply(i.getSubtotal()).setScale(2, RoundingMode.HALF_UP));
        ivm.setProcessingFee(processingFee);
        ivm.setTotal(i.getSubtotal().add(ivm.getTaxAmount()).add(i.getProcessingFee()));

        System.out.println("IVM: " + ivm);
        return ivm;
    }

    public List<InvoiceViewModel> getAllInvoices() {

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice i : invoiceList) {
            InvoiceViewModel ivm = buildInvoiceViewModel(i);
            ivm.setId(i.getInvoiceId());
            ivmList.add(ivm);
        }

        return ivmList;
    }

    @Transactional
    public void updateInvoice(InvoiceViewModel viewModel) {

        // Update invoice information
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(viewModel.getId());
        invoice.setName(viewModel.getName());
        invoice.setStreet(viewModel.getStreet());
        invoice.setCity(viewModel.getCity());
        invoice.setState(viewModel.getState());
        invoice.setZipcode(viewModel.getZipcode());
        invoice.setItemType(viewModel.getItemType());
        invoice.setItemId(viewModel.getItemId());
        invoice.setQuantity(viewModel.getQuantity());

        // Business logic to determine the rest of the invoice.

        Console consoleStock = consoleDao.getConsole(viewModel.getItemId());
        Game gameStock = gameDao.getGame(viewModel.getItemId());
        TShirt tShirtStock = tShirtDao.getTshirt(viewModel.getItemId());

        int quantityOrdered = viewModel.getQuantity();

        // Calculate and obtain unitPrice AND update quantity.
        if (viewModel.getItemType().equals("Consoles")) {
            invoice.setUnitPrice(consoleDao.getConsole(viewModel.getItemId()).getPrice());

            consoleStock.setQuantity(consoleStock.getQuantity() - quantityOrdered);
            consoleDao.updateConsole(consoleStock);

        } else if (viewModel.getItemType().equals("Games")) {
            invoice.setUnitPrice(gameDao.getGame(viewModel.getItemId()).getPrice());

            gameStock.setQuantity(gameStock.getQuantity() - quantityOrdered);
            gameDao.updateGame(gameStock);

        } else if (viewModel.getItemType().equals("T-Shirts")) {
            invoice.setUnitPrice(tShirtDao.getTshirt(viewModel.getItemId()).getPrice());

            tShirtStock.setQuantity(tShirtStock.getQuantity() - quantityOrdered);
            tShirtDao.updateTshirt(tShirtStock);

        }

        // Calculate & obtain subtotal
        invoice.setSubtotal(invoice.getUnitPrice().multiply(BigDecimal.valueOf(viewModel.getQuantity())));

        BigDecimal subtotal = invoice.getSubtotal();
        BigDecimal stateTaxRate = salesTaxDao.getTaxRate(viewModel.getState()).getRate();
        BigDecimal taxAmount = subtotal.multiply(stateTaxRate).setScale(2, RoundingMode.HALF_UP);
        System.out.println("taxAmount: " + taxAmount);

        // Calculate and obtain tax
        invoice.setTax(taxAmount);

        // Calculate and obtain processingFee.
        // If quantity of order exceeds 10, apply + $15.49 to order
        if (viewModel.getQuantity() > 10) {
            invoice.setProcessingFee(processingFeeDao.getProcessingFee(viewModel.getItemType()).getFee().add(new BigDecimal("15.49")));
        } else {
            invoice.setProcessingFee(processingFeeDao.getProcessingFee(viewModel.getItemType()).getFee());
        }

        // Calculate and obtain order total.
        invoice.setTotal(subtotal.add(taxAmount).add(invoice.getProcessingFee()));

        invoiceDao.updateInvoice(invoice);
    }

    @Transactional
    public void removeInvoice(int id) {
        invoiceDao.deleteInvoice(id);
    }

    // -----------------------------------------------------------------------------------------
    // Console API
    public Console saveConsole(Console console) { return consoleDao.addConsole(console); }
    public Console findConsole(int id) { return consoleDao.getConsole(id); }
    public List<Console> findAllConsoles() { return consoleDao.getAllConsoles(); }
    public void updateConsole(Console console) { consoleDao.updateConsole(console); }
    public void removeConsole(int id) { consoleDao.deleteConsole(id); }

    // Game API
    public Game saveGame(Game game) { return gameDao.addGame(game); }
    public Game findGame(int id) { return gameDao.getGame(id); }
    public List<Game> findAllGames() { return gameDao.getAllGames(); }
    public void updateGame(Game game) { gameDao.updateGame(game); }
    public void deleteGame(int id) { gameDao.deleteGame(id); }

    // T-Shirt API
    public TShirt saveTShirt(TShirt tShirt) { return tShirtDao.addTshirt(tShirt); }
    public TShirt findTShirt(int id) { return tShirtDao.getTshirt(id); }
    public List<TShirt> findAllShirts() { return tShirtDao.getAllTshirts(); }
    public void updateTShirt(TShirt tShirt) { tShirtDao.updateTshirt(tShirt); }
    public void deleteTShirt(int id) { tShirtDao.deleteTshirt(id); }

    // Invoice API
    public Invoice saveInvoice(Invoice invoice) { return invoiceDao.addInvoice(invoice); }
    public Invoice findInvoice(int id) { return invoiceDao.getInvoice(id); }
    public List<Invoice> findAllInvoices() { return invoiceDao.getAllInvoices(); }
    public void updateInvoice(Invoice invoice) { invoiceDao.updateInvoice(invoice); }
    public void deleteInvoice(int id) { invoiceDao.deleteInvoice(id); }

    // Processing Fee API
    public ProcessingFee findProcessingFee(String productType) { return processingFeeDao.getProcessingFee(productType); }
    public List<ProcessingFee> findAllFees() { return processingFeeDao.getAllProcessingFees(); }

    // Sales Tax Rate API
    public SalesTaxRate findSalesTaxRate(String state) { return salesTaxDao.getTaxRate(state); }
    public List<SalesTaxRate> findAllTaxRates() { return salesTaxDao.getAllTaxRates(); }


}
