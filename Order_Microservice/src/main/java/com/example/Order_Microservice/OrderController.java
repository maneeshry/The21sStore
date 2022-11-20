package com.example.Order_Microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderservice;

    @Autowired
    private OrderRepository repo;

    @PostMapping("/newOrder")
    public Orders placeOrder(@RequestBody Orders order) {
        return orderservice.placeOrder(order);
    }


    @GetMapping("/orders")
    public Iterable<Orders> getOrders() {
        return repo.findAll();
    }
    
    @GetMapping("/order/{orderId}")
    public Optional<Orders> getOrderById(@PathVariable int orderId) {
        Optional<Orders> order = orderservice.getOrderById(orderId);

        return order;
    }

    @GetMapping("/order/{orderId}/status")
    public String getOrderStatus(@PathVariable int orderId) {
        String status = orderservice.getOrderStatus(orderId);
        return status;
    }

    @PutMapping("/order/cancel/{id}")
    public Orders updateOrder(@PathVariable int id, @RequestBody Orders order) {
        Orders updatedorder = orderservice.updateOrder(id, order);

        return updatedorder;
    }

    @GetMapping("/customer/{customerId}/order")
    public List<Orders> getOrderByCustomerId(@PathVariable int customerId) {
        List<Orders> newOrder = orderservice.getOrderByCustomerId(customerId);

        return newOrder;
    }
}