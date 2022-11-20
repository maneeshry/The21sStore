package com.shoppingservice.ShoppingService.controller;

import java.util.Map.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shoppingservice.ShoppingService.model.*;
import com.shoppingservice.ShoppingService.clients.*;
import org.springframework.http.*;;

@RestController
public class ShoppingServiceController {
  

  @Autowired
  public ProductsProxy productProxy;

  @Autowired
  public OrdersProxy orderProxy;

  @Autowired
  public CartProxy cartProxy;

  int orderId = 3;

  HashMap<String,Integer> hmap = new HashMap<>();
  double value = 0;


  

  @GetMapping("/products")
  public List<CompositeProduct> getAllProducts() {
    List<CompositeProduct> products = productProxy.getAllProducts();
    return products;
  }

  @GetMapping("/products/{id}")
  public Optional<CompositeProduct> getProductById(@PathVariable int id) {
    return productProxy.getProductById(id);
    
  }

  @GetMapping("/products/sortByPrice")
  public List<CompositeProduct> getProductsByPrice() {
    List<CompositeProduct> products = productProxy.getSortByPrice();
    return products;
  }

  @GetMapping("/products/name/{name}")
  public CompositeProduct getProductsByName(@PathVariable String name) {
    return productProxy.getByName(name);
    
  }

 

  @PostMapping("/customer/{customerId}/product/{productName}/cart/add/{quantity}")
  public void addToCart(@PathVariable int customerId, @PathVariable String productName, @PathVariable int quantity) {
    List<CompositeCart> cart = cartProxy.getAllItems();
    List<Integer> list = new ArrayList<>();

    for(int i=0; i<cart.size(); i++) {
      list.add(cart.get(i).getCustomerId());
    }

    if(list.contains(customerId)) {
      CompositeCart temp = cartProxy.getCompositeCart(customerId);
      temp.setQuantity(temp.getQuantity() + quantity);
      temp.setName(temp.getName()+" , "+productName);
      temp.setCustomerId(customerId);
      cartProxy.addCompositeCart(temp);

      if(!hmap.containsKey(productName)) {
        hmap.put(productName, quantity);
      }
      else {
        hmap.put(productName, hmap.get(productName) + quantity);
      }
    }
      else {
        CompositeCart cartItem = new CompositeCart(customerId,quantity,productName);
        cartProxy.addCompositeCart(cartItem);
        if(!hmap.containsKey(productName)) {
          hmap.put(productName, quantity);
        }
        else {
          hmap.put(productName, hmap.get(productName) + quantity);
        }
      }
    } 
    
    @GetMapping("/cart/items")
    public List<CompositeCart> getAllCartItems() {
      List<CompositeCart> cart = cartProxy.getAllItems();
      return cart;
    }
    @PostMapping("/cart/add")
    public void insert(@RequestBody CompositeCart cart) {
      cartProxy.addCompositeCart(cart);
    }
    @DeleteMapping("/cart/{customerId}")
    public void deleteCartItem(@PathVariable int customerId) {
      cartProxy.deleteCartItem(customerId);
    }
    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
      return orderProxy.getAllOrders();
      
    }
    @GetMapping("/orders/{id}")
    public Optional<CompositeOrder> getOrderById(@PathVariable int id) {
      return orderProxy.getOrderById(id);
    }
    @GetMapping("/customer/{customerId}/cart")
    public List<CompositeCart> getCartByCustomerId(@PathVariable int customerId) {
      return cartProxy.getCustomerItems(customerId);
    }
    @GetMapping("/customer/{customerId}/order")
    public List<CompositeOrder> getOrderByCustomerId(@PathVariable int customerId) {
      return orderProxy.getOrderByCustomerId(customerId);
    }
  }