package com.example.Customer_Service.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String email;
    private String address;
    private String orders;

    public Customer() {
    }

    public Customer(int id, String name, String email, String address, String orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddres() {
        return address;
    }

    public void setAddres(String address) {
        this.address = address;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }
}
