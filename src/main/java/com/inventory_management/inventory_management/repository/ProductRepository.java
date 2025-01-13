package com.inventory_management.inventory_management.repository;

import com.inventory_management.inventory_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByProductName(String name);

}
