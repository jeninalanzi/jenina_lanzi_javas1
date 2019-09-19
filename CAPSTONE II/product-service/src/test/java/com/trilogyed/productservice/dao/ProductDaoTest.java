package com.trilogyed.productservice.dao;

import com.trilogyed.productservice.model.Product;
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
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        List<Product> pList = productDao.getAllProducts();
        for (Product p : pList) {
            productDao.deleteProduct(p.getId());
        }
    }

    @Test
    public void addGetDeleteProduct() {
        Product product = new Product();
        product.setProductName("Minecraft Creeper Stuffed Toy");
        product.setProductDescription("Licensed video game toy");
        product.setListPrice(new BigDecimal("25.75"));
        product.setUnitCost(new BigDecimal("15.80"));

        product = productDao.addProduct(product);

        Product product1 = productDao.getProduct(product.getId());

        assertEquals(product1, product);

        productDao.deleteProduct(product.getId());

        product1 = productDao.getProduct(product.getId());

        assertNull(product1);
    }

    @Test
    public void updatePost() {

        Product product = new Product();
        product.setProductName("Minecraft Creeper Stuffed Toy");
        product.setProductDescription("Licensed video game toy");
        product.setListPrice(new BigDecimal("25.75"));
        product.setUnitCost(new BigDecimal("15.80"));

        product = productDao.addProduct(product);

        product.setUnitCost(new BigDecimal("20.80"));
        product.setListPrice(new BigDecimal("23.99"));

        productDao.updateProduct(product);

        Product product1 = productDao.getProduct(product.getId());

        assertEquals(product1, product);
    }

    @Test
    public void getAllProducts() {

        Product product = new Product();
        product.setProductName("Minecraft Creeper Stuffed Toy");
        product.setProductDescription("Licensed video game toy");
        product.setListPrice(new BigDecimal("25.75"));
        product.setUnitCost(new BigDecimal("15.80"));

        Product product1 = new Product();
        product1.setProductName("Mario Party 8");
        product1.setProductDescription("Classic party video game");
        product1.setListPrice(new BigDecimal("30.95"));
        product1.setUnitCost(new BigDecimal("25.10"));

        product = productDao.addProduct(product);
        product1 = productDao.addProduct(product1);

        List<Product> allProducts = productDao.getAllProducts();

        assertEquals(2, allProducts.size());
    }
}
