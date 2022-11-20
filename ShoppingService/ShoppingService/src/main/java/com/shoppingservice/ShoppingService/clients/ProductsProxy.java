package com.shoppingservice.ShoppingService.clients;

import java.util.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.shoppingservice.ShoppingService.model.CompositeProduct;

@FeignClient(name = "product-microservice")
public interface ProductsProxy {

    @GetMapping("/products")
    public List<CompositeProduct> getAllProducts();

    @GetMapping("/products/{id}")
    public Optional<CompositeProduct> getProductById(@PathVariable int id);

    @GetMapping("/products/sortByPrice")
    public List<CompositeProduct> getSortByPrice();

    @GetMapping("/products/category/{category}")
    public List<CompositeProduct> filterByCategory(@PathVariable String category);

    @GetMapping("/products/name/{name}")
    public CompositeProduct getByName(@PathVariable String name);
}