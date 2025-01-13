package com.inventory_management.inventory_management.controller;

import com.inventory_management.inventory_management.model.Product;
import com.inventory_management.inventory_management.service.ProductServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ProductServiceIMP service;

    @GetMapping("/home")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/postdata")
    public Product postProductsData(@RequestBody Product model) {
        System.out.println(model.toString());

        return service.saveProductData(model);
    }

    @GetMapping("/searchedProduct/{product_name}")
    public Product getSearchedProduct(@PathVariable("product_name") String product_name){
        return service.getProductByName(product_name);
    }

    @PutMapping("/updateProduct")
    public Product updateProductRecord(@RequestBody Product model){
        return service.updateProduct(model);
    }
}
