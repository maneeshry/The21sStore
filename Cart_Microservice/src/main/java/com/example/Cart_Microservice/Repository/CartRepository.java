package com.example.Cart_Microservice.Repository;

import com.example.Cart_Microservice.Model.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    List<Cart> findByCustomerId(int customerId);
}
