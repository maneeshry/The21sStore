package com.shoppingservice.ShoppingService.clients;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.shoppingservice.ShoppingService.models.CompositeCart;

@FeignClient(name = "cart-service")
public interface CartProxy {

    @RequestMapping(method = RequestMethod.POST, value = "/cart/add")
    public void addCompositeCart(@RequestBody CompositeCart cartItem);

  @GetMapping("/cart/{cartId}")
  public CompositeCart getCompositeCart(@PathVariable("cartId") int cartId); 

  @GetMapping("/cart/items")
  public List<CompositeCart> getAllItems();   

  @PostMapping("/cart/add")
  public void insert(@RequestBody CompositeCart cart);  

  @DeleteMapping("/cart/{id}")
  public void deleteCartItem(@PathVariable int id);

  @GetMapping("customer/{customerId}/cart")
  public List<CompositeCart> getCustomerItems(@PathVariable int customerId);
}