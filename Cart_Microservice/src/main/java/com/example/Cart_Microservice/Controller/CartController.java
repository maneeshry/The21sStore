package com.example.Cart_Microservice.Controller;

import com.example.Cart_Microservice.Model.Cart;
import com.example.Cart_Microservice.Repository.CartRepository;
//import javassist.NotFoundException;
//import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartRepository repo;

    @GetMapping("/cart/{id}")
    public Cart addItems(@PathVariable int id)
    {
        Cart cart =repo.findById(id).get();

        return cart;
    }

    @GetMapping("/cart/items")
    public List<Cart> getAllItems()
    {
        List<Cart> list= (List<Cart>) repo.findAll();

        return list;
    }

    @PostMapping("/cart/add")
    public void insert(@RequestBody Cart cart) {
        repo.save(cart);
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCartItem(@PathVariable int id)
    {
        Cart cart=repo.findById(id).get();

        repo.delete(cart);
    }

    @GetMapping("/customer/{customerId}/cart")
    public List<Cart> getCustomerItems(@PathVariable int customerId)
    {
        List<Cart> cartList=repo.findByCustomerId(customerId);

        return cartList;
    }
}
