package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    TShirtDao tShirtDao;
    @Autowired
    SalesTaxDao salesTaxDao;
    @Autowired
    ProcessingFeeDao pfDao;


    @Before
    public void setUp() throws Exception {
        List<Invoice> iList = invoiceDao.getAllInvoices();
        for (Invoice i : iList) {
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }

        List<Console> cList = consoleDao.getAllConsoles();
        for (Console c : cList) {
            consoleDao.deleteConsole(c.getId());
        }

        List<Game> gList = gameDao.getAllGames();
        for (Game g : gList) {
            gameDao.deleteGame(g.getId());
        }

        List<TShirt> tList = tShirtDao.getAllTshirts();
        for (TShirt t : tList) {
            tShirtDao.deleteTshirt(t.getId());
        }
    }

    @Test
    public void addGetDeleteInvoice() {

        // Create sample game first + add to db.
        Game game = new Game();
        game.setTitle("Mario Party 9");
        game.setEsrbRating("E");
        game.setDescription("Classic party video game.");
        game.setPrice(new BigDecimal("42.98"));
        game.setStudio("Nintendo");
        game.setQuantity(9);
        game = gameDao.addGame(game);

        // Example invoice for a Game purchase.
        Invoice invoice = new Invoice();
        invoice.setName("Benjamin Fuller");
        invoice.setStreet("304 Test Boulevard");
        invoice.setCity("Gotham");
        invoice.setState("NY");
        invoice.setZipcode("00999");
        invoice.setItemType("Games");
        invoice.setItemId(game.getId());
        invoice.setUnitPrice(game.getPrice());
        invoice.setQuantity(1);
        invoice.setSubtotal(game.getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity())));

        // Some math to obtain the proper tax amount.
        BigDecimal subtotal = invoice.getSubtotal();
        BigDecimal taxRate = salesTaxDao.getTaxRate(invoice.getState()).getRate();
        BigDecimal taxAmount = subtotal.multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_UP);

        invoice.setTax(taxAmount);

        invoice.setProcessingFee(pfDao.getProcessingFee(invoice.getItemType()).getFee());

        // Some math to obtain proper total amount.
        BigDecimal salesTax = invoice.getTax();
        BigDecimal processFee = invoice.getProcessingFee();
        BigDecimal total = subtotal.add(salesTax).add(processFee);

        invoice.setTotal(total);

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice1, invoice);
        System.out.println(invoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertNull(invoice1);
    }

    @Test
    public void getAllInvoices() {

        // Create sample game first + add to db.
        Game game = new Game();
        game.setTitle("Mario Party 9");
        game.setEsrbRating("E");
        game.setDescription("Classic party video game.");
        game.setPrice(new BigDecimal("42.98"));
        game.setStudio("Nintendo");
        game.setQuantity(9);
        game = gameDao.addGame(game);

        // Create sample console first  + add to db.
        Console console = new Console();
        console.setModel("Playstation 3");
        console.setManufacturer("Sony");
        console.setMemoryAmount("512MB");
        console.setProcessor("8 Core 3.2 GHz");
        console.setPrice(new BigDecimal("199.95"));
        console.setQuantity(3);
        console = consoleDao.addConsole(console);

        // Example invoice for a Game purchase.
        Invoice invoice = new Invoice();
        invoice.setName("Benjamin Fuller");
        invoice.setStreet("304 Test Boulevard");
        invoice.setCity("Gotham");
        invoice.setState("NY");
        invoice.setZipcode("00999");
        invoice.setItemType("Games");
        invoice.setItemId(game.getId());
        invoice.setUnitPrice(game.getPrice());
        invoice.setQuantity(1);
        invoice.setSubtotal(game.getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity())));

        // Some math to obtain the proper tax amount.
        BigDecimal subtotal = invoice.getSubtotal();
        BigDecimal taxRate = salesTaxDao.getTaxRate(invoice.getState()).getRate();
        BigDecimal taxAmount = subtotal.multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_UP);

        invoice.setTax(taxAmount);

        invoice.setProcessingFee(pfDao.getProcessingFee(invoice.getItemType()).getFee());

        // Some math to obtain proper total amount.
        BigDecimal salesTax = invoice.getTax();
        BigDecimal processFee = invoice.getProcessingFee();
        BigDecimal total = subtotal.add(salesTax).add(processFee);

        invoice.setTotal(total);

        invoice = invoiceDao.addInvoice(invoice);

        // Create sample invoice for Console purchase.
        // Example invoice for a Game purchase.
        Invoice invoice2 = new Invoice();
        invoice2.setName("Guinevere Camelot");
        invoice2.setStreet("304 Fantasy Lane");
        invoice2.setCity("Boston");
        invoice2.setState("MA");
        invoice2.setZipcode("21444");
        invoice2.setItemType("Consoles");
        invoice2.setItemId(console.getId());
        invoice2.setUnitPrice(console.getPrice());
        invoice2.setQuantity(2);
        invoice2.setSubtotal(console.getPrice().multiply(BigDecimal.valueOf(invoice2.getQuantity())));

        // Some math to obtain the proper tax amount.
        subtotal = invoice2.getSubtotal();
        taxRate = salesTaxDao.getTaxRate(invoice2.getState()).getRate();
        taxAmount = subtotal.multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_UP);

        invoice2.setTax(taxAmount);

        invoice2.setProcessingFee(pfDao.getProcessingFee(invoice2.getItemType()).getFee());

        // Some math to obtain proper total amount.
        salesTax = invoice2.getTax();
        processFee = invoice2.getProcessingFee();
        total = subtotal.add(salesTax).add(processFee);

        invoice2.setTotal(total);

        invoice2 = invoiceDao.addInvoice(invoice2);

        // Just for testing purposes, print out the results so you know what's being pulled.
        System.out.println("Invoice 1 is: " + invoice);
        System.out.println("Invoice 2 is: " + invoice2);

        // Test getAllInvoices() method.
        List<Invoice> allInvoices = invoiceDao.getAllInvoices();
        assertEquals(allInvoices.size(), 2);
    }

    @Test
    public void updateInvoice() {

        // Create a new t-shirt + add to db.
        TShirt tee = new TShirt();
        tee.setSize("S");
        tee.setColor("Green");
        tee.setDescription("Minecraft Creepers Gonna Creep Tee");
        tee.setPrice(new BigDecimal("18.95"));
        tee.setQuantity(5);
        tee = tShirtDao.addTshirt(tee);

        // Create new invoice for a t-shirt purchase.
        Invoice invoice = new Invoice();
        invoice.setName("Kaeden L.");
        invoice.setStreet("555 Awesome Street");
        invoice.setCity("Mount Prospect");
        invoice.setState("IL");
        invoice.setZipcode("60056");
        invoice.setItemType("T-Shirts");
        invoice.setItemId(tee.getId());
        invoice.setUnitPrice(tee.getPrice());
        invoice.setQuantity(1);
        invoice.setSubtotal(tee.getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity())));

        BigDecimal subtotal = invoice.getSubtotal();
        BigDecimal taxRate = salesTaxDao.getTaxRate(invoice.getState()).getRate();
        BigDecimal taxAmount = subtotal.multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_UP);

        invoice.setTax(taxAmount);
        invoice.setProcessingFee(pfDao.getProcessingFee(invoice.getItemType()).getFee());

        // Some math to obtain proper total amount.
        BigDecimal processFee = invoice.getProcessingFee();
        BigDecimal total = subtotal.add(taxAmount).add(processFee);

        invoice.setTotal(total);

        invoice = invoiceDao.addInvoice(invoice);

        System.out.println("Update test results: " + invoice);

        // Update some fields in that invoice.
        invoice.setStreet("214 Cool Street");
        invoice.setCity("Roblox");
        invoice.setZipcode("33333");

        invoiceDao.updateInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertEquals(invoice1, invoice);
    }
}
