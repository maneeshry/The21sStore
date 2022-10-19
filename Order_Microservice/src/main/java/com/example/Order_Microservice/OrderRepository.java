package com.example.Order_Microservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders,Integer> {

    List<Orders> findByCustomerId(int customerId);
}
