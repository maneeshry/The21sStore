package com.example.Order_Microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
*
*  @author AB20184121
*/
@Service
public class OrderService {


    @Autowired
    private OrderRepository orderrepo;

    public Iterable<OrderService_Model> getOrders() {
        return orderrepo.findAll();
    }
    public Optional<OrderService_Model> getOrderById(int orderId) {
        return orderrepo.findById(orderId);
    }

    public OrderService_Model deleteOrderById(int orderId) {
        Optional<OrderService_Model> order = orderrepo.findById(orderId);
        if (order.isPresent()) {
            orderrepo.deleteById(orderId);
            return order.get();
        } else {
            return null;
        }
    }

    public OrderService_Model updateOrder(int id, OrderService_Model order) {
        if (orderrepo.findById(id).isPresent()) {
            return orderrepo.save(order);
        } else {
            return null;
        }
    }

    public OrderService_Model placeOrder(OrderService_Model order) {
        return orderrepo.save(order);
    }

    public List<OrderService_Model> getOrderByCustomerId(int customerId) {

        return (List<OrderService_Model>) orderrepo.findByCustomerId(customerId);
    }
}
//get   //order/cid/orderId