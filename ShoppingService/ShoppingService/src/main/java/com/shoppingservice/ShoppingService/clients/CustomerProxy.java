package com.shoppingservice.ShoppingService.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.shoppingservice.ShoppingService.model.CompositeCustomer;

@FeignClient(name = "customer-service",url = "localhost:8009")
public interface CustomerProxy {

    @GetMapping("/customers/{id}")
    public CompositeCustomer getCustomer(@PathVariable("id") int id);

    @GetMapping("/customers")
    public List<CompositeCustomer> getAllCustomers();

    @PostMapping("/customer/add")
    public void insert(@RequestBody CompositeCustomer customer);

    @GetMapping("/customer/{id}")
    public CompositeCustomer getCustomerById(@PathVariable("id") int id);

    @PostMapping("/customer/{customerId}/product/{productName}/cart/add/{quality}")
    public void insertIntoCart(@PathVariable("customerId") int customerId, @PathVariable("productName") String productName, @PathVariable("quality") int quality);
    }