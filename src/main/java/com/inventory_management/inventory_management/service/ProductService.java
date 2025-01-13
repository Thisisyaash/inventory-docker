package com.inventory_management.inventory_management.service;

import com.inventory_management.inventory_management.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProductData(Product model);

    List<Product> getAllProducts();

    Product getProductByName(String product);

    Product updateProduct(Product record);

    Product getProductById(Long id);
}
