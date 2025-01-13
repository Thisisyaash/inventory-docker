package com.inventory_management.inventory_management.service;

import com.inventory_management.inventory_management.model.Product;
import com.inventory_management.inventory_management.model.ProductStatus;
import com.inventory_management.inventory_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIMP implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public Product saveProductData(Product model) {
        if(model.getStock()>0){
            model.setStatus(ProductStatus.IN_STOCK);
        } else  {
            model.setStatus(ProductStatus.SOLD_OUT);
            model.setStock(0);
        }
        Product savedEntity = repository.save(model);
        return savedEntity;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> listOfProducts = repository.findAll();
        return listOfProducts;
    }

    @Override
    public Product getProductByName(String name) {
        Product product = repository.findByProductName(name);
        return product;
    }



    @Override
    public Product updateProduct(Product record) {
        Product productById = getProductById(record.getProductId());
        productById.setProductName(record.getProductName());
        productById.setDescription(record.getDescription());
        productById.setStock(record.getStock());
//        if(productById.getStock()>0){
//            productById.setStatus(ProductStatus.IN_STOCK);
//        } else  {
//            productById.setStatus(ProductStatus.SOLD_OUT);
//            productById.setStock(0);
//        }
//        saveProductData(productById);

        return saveProductData(productById);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " is not present"));
    }
}
