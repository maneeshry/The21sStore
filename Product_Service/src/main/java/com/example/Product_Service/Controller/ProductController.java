package com.example.Product_Service.Controller;

import com.example.Product_Service.Model.Product;
import com.example.Product_Service.Repository.ProductRepository;
import com.example.Product_Service.Service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductServices services;

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return services.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id)
    {
        Optional<Product> product=services.getProduct(id);
        return product;
    }

    @GetMapping("/products/sortByPrice")
    public List<Product> sortProductPrices()
    {
        return services.sortByPrice();
    }

    @GetMapping("/product/category/{category}")
    public List<Product> filterByCategory(@PathVariable String category)
    {
        List<Product> list=services.filterByCategory(category);
        return list;
    }

    @GetMapping("/products/name/{name}")
    public Product getByName(@PathVariable String name)
    {
        Product product=services.getByName(name);
        return product;
    }

    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        Product newProduct = services.addCustomer(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProduct.getProductId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id,@RequestBody Product product)
    {
        Optional<Product> productOptional=services.getProduct(id);
        product.setProductId(id);
        services.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public Optional<Product> deleteProduct(@PathVariable Long id)
    {
        Optional<Product> product=services.getProduct(id);
        services.deleteProduct(id);
        return product;
    }
}
