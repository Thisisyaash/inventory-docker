package com.inventory_management.inventory_management.service;

import com.inventory_management.inventory_management.model.Product;
import com.inventory_management.inventory_management.model.ProductStatus;
import com.inventory_management.inventory_management.repository.ProductRepository;
import org.antlr.v4.runtime.misc.NotNull;
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
        saveProductData(getStatus(productById));

        return saveProductData(productById);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " is not present"));
    }

    public String deleteProduct(Long product_id){

        if(getProductById(product_id)!=null){
            repository.deleteById(product_id);
            return "product deleted successfully";
        }else {
            return "product deletion unsuccessful";
        }
    }

    @Override
    public Product updateStock(Long product_id ,Long itemsSold){
        Product productById = getProductById(product_id);
        productById.setStock(productById.getStock()-itemsSold);
        Product changesStatusRecord = getStatus(productById);
        System.out.println(changesStatusRecord);
        repository.save(changesStatusRecord);
        return changesStatusRecord;
    }

    public Product getStatus(Product record){
        if(record.getStock()>0){
            record.setStatus(ProductStatus.IN_STOCK);
        } else  {
            record.setStatus(ProductStatus.SOLD_OUT);
            record.setStock(0);
        }

        return record;
    }
}
