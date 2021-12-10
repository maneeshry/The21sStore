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

    @PostMapping("/newOrder")
    public OrderService_Model placeOrder(@RequestBody OrderService_Model order) {
        return orderservice.placeOrder(order);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        Iterable<OrderService_Model> order = orderservice.getOrders();
        if (order == null) {
            throw new EntityNotFoundException();
        } else {
            return ResponseEntity.ok(order);
        }
    }

    @GetMapping("/order/{orderId}")
    public Optional<OrderService_Model> getOrderById(@PathVariable int orderId) {
        Optional<OrderService_Model> order = orderservice.getOrderById(orderId);

        return order;
    }

    @DeleteMapping("/order/{orderId}")
    public OrderService_Model deleteOrder(@PathVariable int orderId) {
        OrderService_Model deletedorder = orderservice.deleteOrderById(orderId);

        return deletedorder;
    }

    @PutMapping("/order/{id}")
    public OrderService_Model updateOrder(@PathVariable int id, @RequestBody OrderService_Model order) {
        OrderService_Model updatedorder = orderservice.updateOrder(id, order);

        return updatedorder;
    }

    @GetMapping("/customer/{customerId}/order")
    public List<OrderService_Model> getOrderByCustomerId(@PathVariable int customerId) {
        List<OrderService_Model> newOrder = orderservice.getOrderByCustomerId(customerId);

        return newOrder;
    }
}