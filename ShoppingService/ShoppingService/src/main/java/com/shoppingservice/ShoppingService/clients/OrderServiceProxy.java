package com.shoppingservice.ShoppingService.clients;
import java.util.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.shoppingservice.ShoppingService.models.OrderMs;

@FeignClient(name = "order-microservice")
public interface OrderServiceProxy {

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders();

    @GetMapping("/orders/{id}")
    public Optional<OrderMs> getOrderById(@PathVariable Long id);

    @PostMapping("/neworders")
    public OrderMs placeOrder(@RequestBody OrderMs order);

    @DeleteMapping("/orders/{id}")
    public OrderMs deleteOrder(@PathVariable int id);

    @PutMapping("/order/{id}")
    public OrderMs updateOrder(@PathVariable int id, @RequestBody OrderMs order);

    @GetMapping("/customer/{customerId}/order")
    public List<OrderMs> getOrderByCustomerId(@PathVariable int customerId);
}