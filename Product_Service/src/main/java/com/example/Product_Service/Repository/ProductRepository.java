package com.example.Product_Service.Repository;

import com.example.Product_Service.Model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findByCategory(String category);
    Product findByProductName(String name);
    List<Product> findByOrderByPriceAsc();
}
