package com.example.Cart_Microservice.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    private int id;
    private int customerId;
    private int quantity;
    private String name;

    public Cart() {
        super();
    }

    public Cart(int id,int customerId, int quantity, String name) {
        this.id = id;
        this.customerId = customerId;
        this.quantity = quantity;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
