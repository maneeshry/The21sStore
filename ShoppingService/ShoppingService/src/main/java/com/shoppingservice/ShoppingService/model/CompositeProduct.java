package com.shoppingservice.ShoppingService.model;

public class CompositeProduct {

  private Long productId;
  private String productName;
  private String category;
  private String description;
  private double price;
  private int totalquantity;
  public CompositeProduct() {
    super();
  }

  public CompositeProduct(Long productId, String productName, String category, String description, double price, int totalquantity) {
    super();
    this.productId = productId;
    this.productName = productName;
    this.category = category;
    this.description = description;
    this.price = price;
    this.totalquantity = totalquantity;
  }

  public Long getProductId() {
    return productId;
  }
  public void setProductId(Long productId) {
    this.productId = productId;
  }
  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public int getTotalquantity() {
    return totalquantity;
  }
  public void setTotalquantity(int totalquantity) {
    this.totalquantity = totalquantity;
  }
  
  
}