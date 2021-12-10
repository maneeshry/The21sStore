package com.shoppingservice.ShoppingService.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.*;
import com.shoppingservice.ShoppingService.model.*;
import com.shoppingservice.ShoppingService.clients.*;

@RestController
public class ShoppingServiceController {
  @Autowired
  public CustomerProxy customerProxy;

  @Autowired
  public ProductServiceProxy productProxy;

  @Autowired
  public OrderServiceProxy orderProxy;

  @Autowired
  public CartProxy cartProxy;

  int orderId = 3;

  HashMap<String,Integer> hmap = new HashMap<>();
  double value = 0;

  @GetMapping("/customers/{id}")
  public CompositeCustomer getCustomer(@PathVariable int id) {
    CompositeCustomer customer = customerProxy.getCompositeCustomerById(id);
    return new CompositeCustomer(customer.getId(), customer.getName(), customer.getEmail() customer.getAddress());
  }

  @GetMapping("/customers")
  public List<CompositeCustomer> getAllCustomers() {
    List<CompositeCustomer> customers = customerProxy.getAllCompositeCustomers();
    return customers;
  }

  @GetMapping("/products")
  public List<CompositeProduct> getAllProducts() {
    List<CompositeProduct> products = productProxy.getAllProducts();
    return products;
  }

  @GetMapping("/products/{id}")
  public Optional<CompositeProduct> getProductById(@PathVariable Long id) {
    CompositeProduct product = productProxy.getProductById(id);
    return product;
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

  @PostMapping("/customer/add")
  public void insert(@RequestBody CompositeCustomer customer) {
    customerProxy.insert(customer);
  }

  @PostMapping("/customer/{customerId}/product/{productName}/cart/add/{quantity}")
  public void addToCart(@PathVariable int customerId, @PathVariable String productName, @PathVariable int quantity) {
    List<CompositeCart> cart = cartProxy.getAllItems();
    List<Integer> list = new ArrayList<>();

    for(int i=0; i<cart.size(); i++) {
      list.add(cart.get(i).getCustomerId());
    }

    if(list.contains(customerId)) {
      CompositeCart temp = cartProxy.getCompositeCartById(customerId);
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
      else {
        CompositeCart cartItem = new CompositeCart(customerId, productName, quantity);
        cartProxy.addCompositeCart(cartItem);
        if(!hmap.containsKey(productName)) {
          hmap.put(productName, quantity);
        }
        else {
          hmap.put(productName, hmap.get(productName) + quantity);
        }
      }
    } 
    @PostMapping("/placeOrder/cart/{customerId}")
    public void placeOrderOnCart(@PathVariable int customerId) {
      CompositeCart cart = cartProxy.getCompositeCartById(customerId);
      String productName = cart.getName();
      for(Entry<String,Integer> entry : hmap.entrySet()) {
        CompositeProduct product = productProxy.getByName(entry.getKey());
        value = value + (product.getPrice() * entry.getValue());
      }
      Order o1 = new Order(orderId, customerId, productName, value,null,"CA");
      productProxy.placeOrder(o1);
      orderId++;
      CompositeCustomer customer = customerProxy.getCompositeCustomerById(customerId);
      String order = customer.getOrder()+o1.toString();
      customer.setOrder(order);
      customer.setId(customerId);
      customerProxy.insert(customer);
      productProxy.deleteCartItem(customerId);
      value = 0;
      hmap.clear();
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
    public Optional<OrderMs> getOrderById(@PathVariable int id) {
      return orderProxy.getOrderById(id);
    }
    @GetMapping("/customer/{customerId}/cart")
    public List<CompositeCart> getCartByCustomerId(@PathVariable int customerId) {
      return cartProxy.getCartByCustomerId(customerId);
    }
    @GetMapping("/customer/{customerId}/order")
    public List<OrderMs> getOrderByCustomerId(@PathVariable int customerId) {
      return orderProxy.getOrderByCustomerId(customerId);
    }
  }