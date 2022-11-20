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

    public Iterable<Orders> getOrders() {
        return orderrepo.findAll();
    }
    public Optional<Orders> getOrderById(int orderId) {
        return orderrepo.findById(orderId);
    }

    public String getOrderStatus(int orderId) {
        Optional<Orders> order = orderrepo.findById(orderId);
        if (order.isPresent()) {
            return order.get().getStatus();
        } else {
            return "Order not found";
        }
    }

    public Orders updateOrder(int id, Orders order) {

        
        order.setStatus("cancelled");
        if (orderrepo.findById(id).isPresent()) {

            return orderrepo.save(order);
        } else {
            return null;
        }
    }

    public Orders placeOrder(Orders order) {
        return orderrepo.save(order);
    }

    public List<Orders> getOrderByCustomerId(int customerId) {

        return (List<Orders>) orderrepo.findByCustomerId(customerId);
    }
}
//get   //order/cid/orderId