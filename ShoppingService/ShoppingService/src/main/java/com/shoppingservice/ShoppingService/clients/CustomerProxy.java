package com.shoppingservice.ShoppingService.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.shoppingservice.ShoppingService.models.CompositeCustomer;

@FeignClient(name = "customer-service")
public interface CustomerProxy {

    @GetMapping("/customers/{id}")
    public CompositeCustomer getCustomer(@PathVariable int id);

    @GetMapping("/customers")
    public List<CompositeCustomer> getAllCustomers();

    @PostMapping("/customer/add")
    public void insert(@RequestBody CompositeCustomer customer);

    @GetMapping("/customer/{id}")
    public CompositeCustomer getCustomerById(@PathVariable int id);

    @PostMapping("/customer/{customerId}/product/{productName}/cart/add/{quality}")
    public void insertIntoCart(@PathVariable int customerId, @PathVariable String productName, @PathVariable int quality);
    }