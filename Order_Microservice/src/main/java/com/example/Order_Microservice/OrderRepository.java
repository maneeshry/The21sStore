package com.example.Order_Microservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderService_Model,Integer> {

    List<OrderService_Model> findByCustomerId(int customerId);
}
