package com.shoppingservice.ShoppingService.clients;
import java.util.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.shoppingservice.ShoppingService.model.CompositeOrder;
import org.springframework.http.*;

@FeignClient(name = "order-microservice", url = "localhost:8008")
public interface OrdersProxy {

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders();

    @GetMapping("/orders/{id}")
    public Optional<CompositeOrder> getOrderById(@PathVariable("id") int id);

    @PostMapping("/neworders")
    public CompositeOrder placeOrder(@RequestBody CompositeOrder order);

    @DeleteMapping("/orders/{id}")
    public CompositeOrder deleteOrder(@PathVariable("id") int id);

    @PutMapping("/order/{id}")
    public CompositeOrder updateOrder(@PathVariable("id") int id, @RequestBody CompositeOrder order);

    @GetMapping("/customer/{customerId}/order")
    public List<CompositeOrder> getOrderByCustomerId(@PathVariable("id") int customerId);
}