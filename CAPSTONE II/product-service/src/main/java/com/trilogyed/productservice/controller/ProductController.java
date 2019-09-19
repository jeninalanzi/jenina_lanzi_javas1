package com.trilogyed.productservice.controller;

import com.trilogyed.productservice.dao.ProductDao;
import com.trilogyed.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CrossOrigin
public class ProductController {

    @Autowired
    ProductDao productDao;

    // POST METHOD
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody @Valid Product product) {
        productDao.addProduct(product);
        return productDao.getProduct(product.getId());
    }


    // GET BY ID METHOD
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Product ID must be greater than 0!");
        }
        return productDao.getProduct(id);
    }


    // GET ALL METHOD
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }


    // UPDATE METHOD
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public void updateProduct(@RequestBody @Valid Product product, @PathVariable int id) {
        for (Product p : productDao.getAllProducts()) {
            if (p.getId() == id) {
                product.setId(id);
                productDao.updateProduct(product);
                System.out.println("Product updated successfully.");
            }
        }
    }


    // DELETE METHOD
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Post ID must be greater than 0!");
        }
        productDao.deleteProduct(id);
        System.out.println("Product successfully deleted from database.");
    }


}
