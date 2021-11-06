package com.example.Customer_Service.Controller;

import com.example.Customer_Service.Model.Customer;
import com.example.Customer_Service.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers()
    {
        return repo.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        Customer customer = repo.getCustomerById(id);
        return customer;
    }

    @PostMapping("/customer/add")
    public void insert(@RequestBody Customer customer)
    {
        repo.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public  void deleteCustomer(@PathVariable int id)
    {
        repo.deleteById(id);
    }

    @PutMapping("/customer/update/{id}")
    public Customer updateCustomer(@PathVariable int id,@RequestBody Customer customer)
    {
        Customer cust=repo.findById(id).get();
        cust.setName(customer.getName());
        cust.setEmail(customer.getEmail());
        cust.setAddres(cust.getAddres());
        repo.save(cust);
        return cust;
    }
}
