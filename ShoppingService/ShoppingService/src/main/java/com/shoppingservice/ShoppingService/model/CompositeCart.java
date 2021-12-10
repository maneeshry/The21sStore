package com.shoppingservice.ShoppingService.model;

public class CompositeCart extends Cart {
  private int customerId;
  private int quantity;
  private String name;
public CompositeCart() {
  super();
}
  public CompositeCart(int customerId, int quantity, String name) {
    this.customerId = customerId;
    this.quantity = quantity;
    this.name = name;
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