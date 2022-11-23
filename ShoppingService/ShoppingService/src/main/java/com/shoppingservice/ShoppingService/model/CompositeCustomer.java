package com.shoppingservice.ShoppingService.model;

import java.util.List;

public class CompositeCustomer {

  private int id;
  private String name;
  private String email;
  private String address;

  private String Orders;

  public CompositeCustomer(int id, String name, String email, String address) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.address = address;
    
  }
  public String getOrders() {
    return Orders;
  }
  public void setOrders(String orders) {
    Orders = orders;
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
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
}