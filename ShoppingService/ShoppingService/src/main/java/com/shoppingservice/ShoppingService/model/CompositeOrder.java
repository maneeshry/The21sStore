package com.shoppingservice.ShoppingService.model;

import java.util.Date;

public class CompositeOrder {
  private int orderId;
  private int customerId;
  private String productName;
  private double amount;
  private Date deliveryDate;
  private String deliveryAddress;

  public CompositeOrder() {
    super();
  }
  public CompositeOrder(int orderId, int customerId, String productName, double amount, Date deliveryDate, String deliveryAddress) {
    super();
    this.orderId = orderId;
    this.customerId = customerId;
    this.productName = productName;
    this.amount = amount;
    this.deliveryDate = deliveryDate;
    this.deliveryAddress = deliveryAddress;
  } 
  public int getOrderId() {
    return orderId;
  }
  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }
  public int getCustomerId() {
    return customerId;
  }
  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }
  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }
  public double getAmount() {
    return amount;
  }
  public void setAmount(double amount) {
    this.amount = amount;
  }
  public Date getDeliveryDate() {
    return deliveryDate;
  }
  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }
  public String getDeliveryAddress() {
    return deliveryAddress;
  }
  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }
  
}