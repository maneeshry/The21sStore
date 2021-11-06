package com.example.Product_Service.Service;

import com.example.Product_Service.Model.Product;
import com.example.Product_Service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts()
    {
        return (List<Product>) repo.findAll();
    }

    public Optional<Product> getProduct(Long id)
    {
        return repo.findById(id);
    }

    public Product addCustomer(Product product)
    {
        return repo.save(product);
    }

    public void updateProduct(Product product)
    {
        repo.save(product);
    }

    public void deleteProduct(Long id)
    {
         repo.deleteById(id);
    }

    public Product getByName(String name)
    {
        return repo.findByProductName(name);
    }

    public List<Product> filterByCategory(String category)
    {
        return repo.findByCategory(category);
    }

    public List<Product> sortByPrice()
    {
        return repo.findByOrderByPriceAsc();
    }
}
