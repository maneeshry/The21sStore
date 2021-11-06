package com.example.Customer_Service.Repository;

import com.example.Customer_Service.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer getCustomerById(int id);
}
