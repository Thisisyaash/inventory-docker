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

    @PostMapping("/postProduct")
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

    @DeleteMapping("/deleteProduct/{product_id}")
    public String deleteProduct(@PathVariable ("product_id") Long product_id){
        return service.deleteProduct(product_id);
    }

    @PutMapping("/itemsSold/{product_id}/{itemsSold}")
    public Product updateStock(@PathVariable("product_id") Long product_id, @PathVariable ("itemsSold") Long itemsSold){
        return service.updateStock(product_id,itemsSold) ;
    }

    @GetMapping("/searchProductById/{product_id}")
    public Product getProductById(@PathVariable Long product_id){
        return service.getProductById(product_id);
    }

}
